package vrsalex.matule.presentation.auth.account_password

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vrsalex.matule.data.repository.AuthSessionRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class AccountPasswordViewModel @Inject constructor(
    private val authSessionRepositoryImpl: AuthSessionRepositoryImpl
): ViewModel() {

    private val _state = MutableStateFlow(AccountPasswordContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<AccountPasswordContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: AccountPasswordContract.Event){
        when(event) {
            is AccountPasswordContract.Event.PasswordChanged -> _state.update { it.copy(password = event.password) }
            is AccountPasswordContract.Event.ConfirmPasswordChanged -> _state.update{ it.copy(confirmPassword = event.confirmPassword)}
            AccountPasswordContract.Event.OnNext -> onNext()
        }
    }

    fun onNext() = viewModelScope.launch {
        if (state.value.isEnabledButton) {
            authSessionRepositoryImpl.data.update { it?.copy(password = state.value.password) }
            _effect.send(AccountPasswordContract.Effect.OnNext)
        }
    }

}