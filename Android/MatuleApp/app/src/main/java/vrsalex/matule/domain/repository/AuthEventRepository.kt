package vrsalex.matule.domain.repository

import kotlinx.coroutines.flow.SharedFlow

interface AuthEventRepository {
    val authEvents: SharedFlow<AuthEvent>
    suspend fun logout()

}

sealed class AuthEvent {
    data object Logout : AuthEvent()
}
