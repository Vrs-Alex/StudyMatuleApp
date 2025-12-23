package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.domain.repository.AuthEvent
import vrsalex.matule.domain.repository.AuthEventRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthEventRepositoryImpl @Inject constructor(
    private val tokenManager: TokenManager,
    private val securitySettingsManager: SecuritySettingsManager
) : AuthEventRepository {
    private val _authEvents = MutableSharedFlow<AuthEvent>()
    override val authEvents: SharedFlow<AuthEvent> = _authEvents.asSharedFlow()

    override suspend fun logout() {
        tokenManager.clearTokens()
        securitySettingsManager.clearAll()
        _authEvents.emit(AuthEvent.Logout)
    }
}