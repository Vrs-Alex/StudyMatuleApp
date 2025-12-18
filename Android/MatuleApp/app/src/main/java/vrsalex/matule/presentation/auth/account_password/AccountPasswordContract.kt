package vrsalex.matule.presentation.auth.account_password

object AccountPasswordContract {

    data class State(
        val password: String = "",
        val confirmPassword: String = ""
    ){
        val isEnabledButton: Boolean get() =
            password.isNotEmpty() && confirmPassword.isNotEmpty() && password == confirmPassword
    }

    sealed interface Event {
        data class PasswordChanged(val password: String) : Event
        data class ConfirmPasswordChanged(val confirmPassword: String) : Event
        data object OnNext : Event
    }

    sealed interface Effect {
        data object OnNext: Effect
    }

}