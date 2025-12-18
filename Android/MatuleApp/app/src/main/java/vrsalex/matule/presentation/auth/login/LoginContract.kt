package vrsalex.matule.presentation.auth.login

object LoginContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false
    ){
        val isEnabledButton: Boolean get() = email.isNotEmpty() && password.isNotEmpty() && !isLoading
    }


    sealed interface Event{
        data class EmailChanged(val email: String) : Event
        data class PasswordChanged(val password: String) : Event
        object LoginClicked : Event
    }

    sealed interface Effect {
        data object OnLogin: Effect
        data object OnRegister: Effect
    }

}