package vrsalex.matule.presentation.feature.auth.verify_phone

object VerifyPhoneContract {

    data class State(
        val code: String = "",
        val codeLength: Int = 4,
        val timerValue: Int = 60,
        val isTimerRunning: Boolean = true,
        val isLoading: Boolean = false,
        val error: String? = null
    ){
        val canResendCode: Boolean
            get() = timerValue == 0 && !isTimerRunning && !isLoading
        val isCodeComplete: Boolean
            get() = code.length == codeLength
    }


    sealed interface Event {
        data class OnCodeChanged(val newCode: String) : Event
        data object OnResendCodeClick : Event

        data class TimerTick(val remainingSeconds: Int) : Event
        data object TimerFinished : Event
    }

    sealed interface Effect {
        data object NavigateToNextScreen : Effect
        data class ShowError(val message: String) : Effect
    }

}