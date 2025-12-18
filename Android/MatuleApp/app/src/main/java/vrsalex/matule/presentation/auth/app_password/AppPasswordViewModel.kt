package vrsalex.matule.presentation.auth.app_password

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
import javax.inject.Inject

@HiltViewModel
class AppPasswordViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(AppPasswordContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<AppPasswordContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: AppPasswordContract.Event) {
        when(event) {
            is AppPasswordContract.Event.NumberClicked -> {
                if (state.value.pinCode.length < state.value.pinCodeLength) {
                    _state.update { it.copy(pinCode = it.pinCode + event.number) }

                    if (state.value.isPinCodeComplete) {
                        viewModelScope.launch {
                            delay(250)
                            _effect.send(AppPasswordContract.Effect.OnNext)
                        }
                    }
                }
            }
            AppPasswordContract.Event.OnDeleteClicked -> {
                _state.update { it.copy(pinCode = it.pinCode.dropLast(1)) }
            }
            AppPasswordContract.Event.OnSkipped -> {
                viewModelScope.launch { _effect.send(AppPasswordContract.Effect.OnSkipped) }
            }
        }
    }

}