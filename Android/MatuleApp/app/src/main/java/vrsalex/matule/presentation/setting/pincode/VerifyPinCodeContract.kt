package vrsalex.matule.presentation.setting.pincode

object VerifyPinCodeContract {

    data class State(
        val pinCode: String = "",
        val pinCodeLength: Int = 4
    ){
        val isPinCodeComplete: Boolean get() = pinCode.length == pinCodeLength
    }

    sealed interface Event {
        data class NumberClicked(val number: String) : Event
        data object OnDeleteClicked : Event
    }

    sealed interface Effect {
        data object OnSuccess: Effect
        data object OnErrorPinCode: Effect
    }

}