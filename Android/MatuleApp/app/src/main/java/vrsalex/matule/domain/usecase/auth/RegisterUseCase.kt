package vrsalex.matule.domain.usecase.auth

import vrsalex.matule.domain.model.auth.RegisterResult
import vrsalex.matule.domain.model.auth.RegistrationData
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(data: RegistrationData): RegisterResult{
        return authRepository.register(data)
    }
}