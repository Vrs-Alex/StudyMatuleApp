package vrsalex.matule.data.repository

import android.util.Log
import retrofit2.HttpException
import vrsalex.matule.data.remote.api.AuthApi
import vrsalex.matule.data.remote.dto.auth.LoginRequest
import vrsalex.matule.data.remote.dto.auth.LoginResponse
import vrsalex.matule.domain.repository.AuthRepository
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun login(email: String, password: String): LoginResponse {
        try {
            return authApi.login(LoginRequest(email, password))
        } catch (e: HttpException) {
            // Ошибка сервера (например, 401 или 404)
            Log.e("MYAPP", "Ошибка сервера: ${e.code()}")
            throw Exception("Ошибка сервера: ${e.code()}")
        } catch (e: IOException) {
            // Ошибка сети (нет интернета)
            Log.e("MYAPP", "Проверьте подключение к интернету")
            throw Exception("Проверьте подключение к интернету")
        } catch (e: Exception) {
            throw e
        }
    }
}