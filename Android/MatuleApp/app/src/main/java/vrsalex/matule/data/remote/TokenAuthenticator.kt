package vrsalex.matule.data.remote

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Dispatcher
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.HttpException
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
            return runBlocking(Dispatchers.IO) {
                try {
                    val currentAccessToken = tokenManager.getAccessToken().first()
                    val currentRefreshToken = tokenManager.getRefreshToken().first()

                    if (currentAccessToken == null || currentRefreshToken == null) {
                        authEventRepository.logout()
                        return@runBlocking null
                    }
                    val requestToken = response.request.header("Authorization")
                        ?.removePrefix("Bearer ")
                    if (requestToken != currentAccessToken) {
                        return@runBlocking response.request.newBuilder()
                            .header("Authorization", "Bearer $currentAccessToken")
                            .build()
                    }
                    val newAuthResponse = try {
                        authApi.get().refreshToken(RefreshTokenRequest(currentRefreshToken))
                    } catch (e: HttpException) {
                        if (e.code() == 401 || e.code() == 403) {
                            authEventRepository.logout()
                            return@runBlocking null
                        } else {
                            throw e
                        }
                    } catch (e: Exception) {
                        throw e
                    }

                    tokenManager.saveAccessToken(newAuthResponse.accessToken)
                    tokenManager.saveRefreshToken(newAuthResponse.refreshToken)
                    response.request.newBuilder()
                        .header("Authorization", "Bearer ${newAuthResponse.accessToken}")
                        .build()

                } catch (e: Exception) {
                    Log.e("AUTH", "Не удалось обновить токен: ${e.message}")
                    null
                }
            }
        }
    }
}