package vrsalex.matuleapp.presentation.feature.auth.signin

sealed interface SignInEvent {
    data class EmailChanged(val value: String) : SignInEvent
    data class PasswordChanged(val value: String) : SignInEvent
    object LoginClicked : SignInEvent
}