package vrsalex.matule.presentation.auth.verify_phone

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
import javax.inject.Inject

@HiltViewModel
class VerifyPhoneViewModel @Inject constructor(): ViewModel() {

    init {
        timer()
    }

    private var timerJob: Job? = null

    private val _state = MutableStateFlow(VerifyPhoneContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<VerifyPhoneContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: VerifyPhoneContract.Event) {
        when(event) {
            is VerifyPhoneContract.Event.CodeChanged -> {
                val cleanCode = event.code.take(state.value.codeLength)
                _state.update { it.copy(code = cleanCode) }

                if (state.value.isCodeComplete) {
                    checkCode()
                }
            }
            VerifyPhoneContract.Event.ResendCodeClicked -> {
                _state.update { it.copy(resendTime = 60) }
                timer()
            }
        }
    }

    fun checkCode() = viewModelScope.launch {
        if (state.value.code == "1234"){
            _effect.send(VerifyPhoneContract.Effect.OnNext)
        }
    }

    fun timer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (state.value.resendTime > 0) {
                delay(1000)
                _state.update { it.copy(resendTime = it.resendTime - 1) }
            }
        }
    }

}