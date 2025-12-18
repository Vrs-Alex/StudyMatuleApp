package vrsalex.matule.presentation.auth.verify_phone

object VerifyPhoneContract {

    data class State(
        val code: String = "",
        val codeLength: Int = 4,
        val resendTime: Int = 55,
        val isLoading: Boolean = false
    ){
        val isCodeComplete: Boolean get() = code.length == codeLength
        val isTimerActive: Boolean get() = resendTime > 0
    }

    sealed interface Event {
        data class CodeChanged(val code: String) : Event
        data object ResendCodeClicked : Event
    }

    sealed interface Effect {
        data object OnNext: Effect
    }

}