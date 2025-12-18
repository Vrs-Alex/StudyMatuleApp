package vrsalex.matule.domain.usecase

import vrsalex.matule.data.remote.dto.auth.LoginResponse
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): LoginResponse {
        return authRepository.login(email, password)
    }
}