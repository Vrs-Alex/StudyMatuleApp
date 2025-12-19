package vrsalex.matule.domain.repository

import vrsalex.matule.domain.model.auth.AuthResult

interface AuthRepository {


    suspend fun login(email: String, password: String): AuthResult


}