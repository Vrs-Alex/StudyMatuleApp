package vrsalex.matule.application.handler.auth

import org.springframework.stereotype.Component
import vrsalex.matule.application.command.auth.RefreshTokenCommand
import vrsalex.matule.application.exception.exc.InvalidRefreshTokenException
import vrsalex.matule.application.result.auth.RefreshTokenResult
import vrsalex.matule.domain.port.repository.RefreshTokenRepository
import vrsalex.matule.domain.port.security.JwtService
import vrsalex.matule.domain.port.security.TokenEncoder

@Component
class RefreshTokenCommandHandler(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val tokenEncoder: TokenEncoder,
    private val jwtService: JwtService
) {

    operator fun invoke(command: RefreshTokenCommand): RefreshTokenResult{
        if (!jwtService.validateRefreshToken(command.token))
            throw InvalidRefreshTokenException("Неверный токен обновления.")
        val tokenId = jwtService.getIdFromToken(command.token)
        val token = refreshTokenRepository.findById(tokenId)
            ?: throw InvalidRefreshTokenException("Неверный токен обновления.")

        if (!tokenEncoder.matches(command.token, token.tokenHash))
            throw InvalidRefreshTokenException("Неверный токен обновления.")

        val newTokens = jwtService.generateTokens(token.userId)
        val newHashedToken = tokenEncoder.encode(newTokens.refreshToken)
        refreshTokenRepository.save(token.copy(tokenHash = newHashedToken))

        return newTokens
    }

}