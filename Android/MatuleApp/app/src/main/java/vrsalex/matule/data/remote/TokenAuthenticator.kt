package vrsalex.matule.data.remote

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
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
import javax.inject.Singleton

@Singleton
class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    private val authApi: Provider<AuthApi>,
    private val authEventRepository: AuthEventRepository
): Authenticator {

    private val refreshMutex = Mutex()

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.retryCount > 3) return null

        return runBlocking {
            refreshMutex.withLock {
                val currentAccessToken = tokenManager.getAccessToken().first()
                    ?: return@runBlocking null

                val requestToken = response.request.header("Authorization")?.removePrefix("Bearer ")

                if (requestToken != currentAccessToken) {
                    return@runBlocking response.request.newBuilder()
                        .header("Authorization", "Bearer $currentAccessToken")
                        .build()
                }

                val currentRefreshToken = tokenManager.getRefreshToken().first()
                if (currentRefreshToken == null) {
                    authEventRepository.logout()
                    return@runBlocking null
                }

                try {
                    val newAuthResponse = authApi.get().refreshToken(RefreshTokenRequest(currentRefreshToken))

                    tokenManager.saveAccessToken(newAuthResponse.accessToken)
                    tokenManager.saveRefreshToken(newAuthResponse.refreshToken)

                    response.request.newBuilder()
                        .header("Authorization", "Bearer ${newAuthResponse.accessToken}")
                        .build()
                } catch (e: Exception) {
                    if (e is HttpException && (e.code() == 401 || e.code() == 403)) {
                        authEventRepository.logout()
                    }
                    null
                }
            }
        }

    }

    private val Response.retryCount: Int
        get() {
            var count = 0
            var res = priorResponse
            while (res != null) {
                count++
                res = res.priorResponse
            }
            return count
        }

}