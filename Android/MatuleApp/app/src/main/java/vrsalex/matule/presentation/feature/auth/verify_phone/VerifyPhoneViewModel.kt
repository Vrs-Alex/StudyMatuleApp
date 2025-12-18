package vrsalex.matule.presentation.feature.auth.verify_phone

import androidx.activity.result.launch
import androidx.compose.animation.core.copy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vrsalex.matule.domain.repository.AuthSessionRepository
import javax.inject.Inject
import kotlin.concurrent.atomics.update

@HiltViewModel
class VerifyPhoneViewModel @Inject constructor(
    private val authSessionRepository: AuthSessionRepository
) : ViewModel() {


    private val _state = MutableStateFlow(VerifyPhoneContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<VerifyPhoneContract.Effect>()
    val effect = _effect.receiveAsFlow()

    private var timerJob: Job? = null

    init {
        startTimer()
    }

    fun onEvent(event: VerifyPhoneContract.Event) {
        when (event) {
            is VerifyPhoneContract.Event.OnCodeChanged -> {
                // Ограничиваем ввод только цифрами и длиной кода
                if (event.newCode.length <= _state.value.codeLength && event.newCode.all { it.isDigit() }) {
                    _state.update { it.copy(code = event.newCode, error = null) }

                    // Если код введен полностью — автоматически проверяем его
                    if (_state.value.isCodeComplete) {
                        verifyCode(_state.value.code)
                    }
                }
            }

            is VerifyPhoneContract.Event.OnResendCodeClick -> {
                resendCode()
            }

            is VerifyPhoneContract.Event.TimerTick -> {
                _state.update { it.copy(timerValue = event.remainingSeconds) }
            }

            VerifyPhoneContract.Event.TimerFinished -> {

            }
        }
    }

    private fun startTimer() {
        timerJob?.cancel()

        _state.update { it.copy(timerValue = 60, isTimerRunning = true) }

        timerJob = viewModelScope.launch {
            while (_state.value.timerValue > 0) {
                delay(1000)
                val newValue = _state.value.timerValue - 1
                onEvent(VerifyPhoneContract.Event.TimerTick(newValue))
            }
            _state.update { it.copy(isTimerRunning = false) }
        }
    }

    private fun verifyCode(code: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            // Имитация запроса к API
            delay(1500)

            val isCodeCorrect = code == "1234" // Замените на реальную логику

            _state.update { it.copy(isLoading = false) }

            if (isCodeCorrect) {
                _effect.send(VerifyPhoneContract.Effect.NavigateToNextScreen)
            } else {
                _state.update { it.copy(code = "", error = "Неверный код") }
                _effect.send(VerifyPhoneContract.Effect.ShowError("Код не совпадает"))
            }
        }
    }

    private fun resendCode() {
        if (!_state.value.canResendCode) return

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            // Имитация запроса на повторную отправку
            delay(1000)

            _state.update { it.copy(isLoading = false) }

            // После успешной переотправки сбрасываем код и запускаем таймер заново
            _state.update { it.copy(code = "") }
            startTimer()
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel() // Очищаем ресурсы
    }

}