package vrsalex.matule.domain.repository

import vrsalex.matule.data.remote.dto.auth.LoginResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): LoginResponse
}