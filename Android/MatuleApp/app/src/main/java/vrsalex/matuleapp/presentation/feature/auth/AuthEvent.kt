package vrsalex.matuleapp.presentation.feature.auth

sealed interface AuthEvent {
    data class EmailChanged(val value: String) : AuthEvent
    data class PasswordChanged(val value: String) : AuthEvent
    object LoginClicked : AuthEvent
}