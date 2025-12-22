package vrsalex.matule.domain.usecase.auth

import vrsalex.matule.domain.model.auth.VerifyResult
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject


class VerifyPhoneUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(phone: String, code: String): VerifyResult{
        return authRepository.verify(phone, code)
    }

}