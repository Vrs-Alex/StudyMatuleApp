package vrsalex.matule.domain.repository

import vrsalex.matule.domain.model.auth.LoginResult
import vrsalex.matule.domain.model.auth.RegisterResult
import vrsalex.matule.domain.model.auth.RegistrationData
import vrsalex.matule.domain.model.auth.VerifyResult

interface AuthRepository {


    suspend fun login(email: String, password: String): LoginResult

    suspend fun register(data: RegistrationData): RegisterResult

    suspend fun verify(phone: String, code: String): VerifyResult

}