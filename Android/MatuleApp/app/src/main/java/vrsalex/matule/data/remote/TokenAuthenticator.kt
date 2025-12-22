package vrsalex.matule.data.remote

import android.util.Log
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.data.remote.api.AuthApi
import vrsalex.matule.data.remote.dto.auth.AuthResponse
import vrsalex.matule.data.remote.dto.auth.RefreshTokenRequest
import vrsalex.matule.domain.repository.AuthEventRepository
import javax.inject.Inject
import javax.inject.Provider

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    private val authApi: Provider<AuthApi>,
    private val authEventRepository: AuthEventRepository
): Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.priorResponse != null) return null

        synchronized(this){
            val currentToken = runBlocking { tokenManager.getAccessToken().first() }
            val refreshToken = runBlocking { tokenManager.getRefreshToken().first() }
            if (currentToken == null || refreshToken == null) {
                runBlocking { authEventRepository.logout() }
                return null
            }

            val requestToken = response.request.header("Authorization")?.removePrefix("Bearer ")

            val tokenToUse = if (requestToken != currentToken) {
                currentToken
            } else {
                val authResponse = refreshToken(refreshToken)
                if (authResponse != null) {
                        runBlocking {
                            tokenManager.saveAccessToken(authResponse.accessToken)
                            tokenManager.saveRefreshToken(authResponse.refreshToken)
                        }
                        authResponse.accessToken
                    } else {
                        null
                    }
            }

            return if (tokenToUse != null) {
                response.request.newBuilder()
                    .header("Authorization", "Bearer $tokenToUse")
                    .build()
            } else {
                Log.e("MYAPP", "123")
                runBlocking { authEventRepository.logout() }
                null
            }
        }
    }

    private fun refreshToken(currentToken: String): AuthResponse? = runBlocking {
        Log.d("AUTH", "1. Пытаюсь обновить токен...")
        try {
            val apiResponse = authApi.get().refreshToken(RefreshTokenRequest(currentToken))
            Log.d("AUTH", "2. Успех!")
            apiResponse
        } catch (t: Throwable) { // Используем Throwable вместо Exception
            Log.e("AUTH", "3. Поймали ошибку: ${t.message}")
            null
        } finally {
            Log.d("AUTH", "4. Блок finally сработал")
        }
    }
}