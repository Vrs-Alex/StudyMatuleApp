package vrsalex.matule.data.remote.api

import retrofit2.http.Body
import retrofit2.http.POST
import vrsalex.matule.data.remote.dto.auth.LoginRequest
import vrsalex.matule.data.remote.dto.auth.LoginResponse

interface AuthApi {

    @POST("api/auth/login")
    suspend fun login(@Body data: LoginRequest): LoginResponse

}