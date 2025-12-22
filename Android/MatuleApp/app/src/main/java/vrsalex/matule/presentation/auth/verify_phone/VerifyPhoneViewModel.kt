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
import vrsalex.matule.data.repository.AuthSessionRepositoryImpl
import vrsalex.matule.domain.model.auth.VerifyResult
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class VerifyPhoneViewModel @Inject constructor(
    private val authSessionRepositoryImpl: AuthSessionRepositoryImpl,
    private val authRepository: AuthRepository
): ViewModel() {

    private var timerJob: Job? = null

    private val _state = MutableStateFlow(VerifyPhoneContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<VerifyPhoneContract.Effect>()
    val effect = _effect.receiveAsFlow()

    init {
        timer()
    }

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

            VerifyPhoneContract.Event.BackClicked -> {
                viewModelScope.launch {
                    _effect.send(VerifyPhoneContract.Effect.OnBack)
                }
            }
        }
    }

    fun checkCode() = viewModelScope.launch {
        val res = authRepository.verify(
            authSessionRepositoryImpl.data.value!!.phoneNum,
            state.value.code
        )
        when(res) {
            VerifyResult.Success -> {
                _effect.send(VerifyPhoneContract.Effect.OnNext)
            }
            VerifyResult.TimeExpired -> {
                _effect.send(VerifyPhoneContract.Effect.OnRegistrationRestart)
            }
            is VerifyResult.Error -> {
                _effect.send(VerifyPhoneContract.Effect.OnRegistrationRestart)
            }
        }
        authSessionRepositoryImpl.clearData()
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