package vrsalex.matule.presentation.auth.app_password

object AppPasswordContract {

    data class State(
        val pinCode: String = "",
        val pinCodeLength: Int = 4
    ){
        val isPinCodeComplete: Boolean get() = pinCode.length == pinCodeLength
    }

    sealed interface Event {
        data class NumberClicked(val number: String) : Event
        data object OnDeleteClicked : Event
        data object OnSkipped : Event
    }

    sealed interface Effect {
        data object OnNext: Effect
        data object OnSkipped: Effect
    }

}