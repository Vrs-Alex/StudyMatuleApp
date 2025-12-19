package vrsalex.matule.data.repository

import retrofit2.HttpException
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.data.remote.api.AuthApi
import vrsalex.matule.data.remote.dto.auth.SignInRequest
import vrsalex.matule.domain.model.auth.AuthResult
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): AuthResult {
        return try {
            val response = authApi.login(SignInRequest(email,password))

            tokenManager.saveAccessToken(response.accessToken)
            tokenManager.saveRefreshToken(response.refreshToken)

            AuthResult.Success
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> AuthResult.InvalidCredentials
                406 -> AuthResult.UserNotFound
                else -> AuthResult.Error("Ошибка сервера: ${e.code()}")
            }
        } catch (e: Exception) {
            AuthResult.Error("Проблемы с сетью")
        }
    }
}