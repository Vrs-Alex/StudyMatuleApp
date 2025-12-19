package vrsalex.matule.presentation.setting.pincode

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vrsalex.matule.domain.usecase.setting.MatchPinCodeUseCase
import javax.inject.Inject

@HiltViewModel
class VerifyPinCodeViewModel @Inject constructor(
    private val matchPinCodeUseCase: MatchPinCodeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(VerifyPinCodeContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<VerifyPinCodeContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: VerifyPinCodeContract.Event){
        when(event) {
            is VerifyPinCodeContract.Event.NumberClicked -> {
                val newPin = state.value.pinCode + event.number
                _state.update { it.copy(pinCode = newPin) }

                if (newPin.length == state.value.pinCodeLength) {
                    viewModelScope.launch {
                        delay(200)
                        val isValid = matchPinCodeUseCase(newPin)

                        if (isValid) {
                            _effect.send(VerifyPinCodeContract.Effect.OnSuccess)
                        } else {
                            delay(300)
                            _state.update { it.copy(pinCode = "") }
                            _effect.send(VerifyPinCodeContract.Effect.OnErrorPinCode)
                        }
                    }
                }
            }
            VerifyPinCodeContract.Event.OnDeleteClicked -> {
                _state.update { it.copy(pinCode = it.pinCode.dropLast(1)) }
            }
        }
    }

}