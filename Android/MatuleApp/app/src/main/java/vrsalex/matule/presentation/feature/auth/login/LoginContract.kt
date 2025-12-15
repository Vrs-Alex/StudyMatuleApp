package vrsalex.matule.presentation.feature.auth.login

object LoginContract {
    data class LoginState(
        val email: String = "",
        val password: String = "",
        val isButtonEnabled: Boolean = false
    )

    sealed interface LoginEvent {
        data class EmailChanged(val email: String) : LoginEvent
        data class PasswordChanged(val password: String) : LoginEvent
        data class OnLoginClick(val email: String, val password: String) : LoginEvent
    }

    sealed interface Effect {
        data object NavigateToCreateAppPassword : Effect
        data object NavigateToCreateProfile : Effect
    }

}