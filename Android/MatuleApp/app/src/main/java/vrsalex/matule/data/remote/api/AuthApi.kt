package vrsalex.matule.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import vrsalex.matule.data.remote.dto.auth.AuthResponse
import vrsalex.matule.data.remote.dto.auth.LogoutRequest
import vrsalex.matule.data.remote.dto.auth.SignInRequest
import vrsalex.matule.data.remote.dto.auth.SignUpRequest
import vrsalex.matule.data.remote.dto.auth.VerifySignUpRequest


interface AuthApi {

    @POST("auth/login")
    suspend fun login(@Body request: SignInRequest): AuthResponse // 406

    @POST("auth/register")
    suspend fun register(@Body request: SignUpRequest): Response<Unit> // 202 409

    @POST("auth/register/verify")
    suspend fun verify(@Body request: VerifySignUpRequest): AuthResponse // 401

    @POST("auth/logout")
    suspend fun logout(@Body request: LogoutRequest): Response<Unit> // 204 401

}