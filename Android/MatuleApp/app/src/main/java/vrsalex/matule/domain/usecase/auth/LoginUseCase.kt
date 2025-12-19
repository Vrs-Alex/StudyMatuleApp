package vrsalex.matule.domain.usecase.auth

import vrsalex.matule.domain.model.auth.AuthResult
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(email: String, pass: String): AuthResult {// Здесь можно добавить валидацию перед запросом
        if (!email.contains("@")) return AuthResult.Error("Некорректный email")

        return authRepository.login(email, pass)
    }

}