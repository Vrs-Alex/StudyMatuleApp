package vrsalex.matule.presentation.feature.auth.login

object LoginContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val isButtonEnabled: Boolean = false
    )

    sealed interface Event {
        data class EmailChanged(val email: String) : Event
        data class PasswordChanged(val password: String) : Event
        data class OnClick(val email: String, val password: String) : Event
    }

    sealed interface Effect {
        data object NavigateToCreateAppPassword : Effect
        data object NavigateToCreateProfile : Effect
    }

}