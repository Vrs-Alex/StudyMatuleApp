package vrsalex.matule.data.local.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {
    suspend fun saveAccessToken(token: String) = dataStoreManager.saveAccessToken(token)

    suspend fun saveRefreshToken(token: String) = dataStoreManager.saveRefreshToken(token)

    suspend fun clearTokens() = dataStoreManager.clearTokens()

    fun getRefreshToken(): Flow<String?> = dataStoreManager.getRefreshToken()

    fun getAccessToken(): Flow<String?> = dataStoreManager.getAccessToken()

    suspend fun isHaveTokens(): Boolean {
        return getAccessToken().first() != null
                && getRefreshToken().first() != null
    }
}