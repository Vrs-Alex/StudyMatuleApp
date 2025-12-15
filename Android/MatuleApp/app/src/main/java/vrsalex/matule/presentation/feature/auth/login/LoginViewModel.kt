package vrsalex.matule.presentation.feature.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(LoginContract.LoginState())
    val state get() = _state.asStateFlow()

    private val _effect = Channel<LoginContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: LoginContract.LoginEvent) {
        when(event){
            is LoginContract.LoginEvent.OnLoginClick -> {
                login()
            }
            is LoginContract.LoginEvent.EmailChanged -> {
                _state.value = state.value.copy(email = event.email)
                isButtonEnabled()
            }
            is LoginContract.LoginEvent.PasswordChanged -> {
                _state.value = state.value.copy(password = event.password)
                isButtonEnabled()
            }
        }
    }

    private fun isButtonEnabled(){
        val isEnabled = state.value.email.isNotEmpty() && state.value.password.isNotEmpty()
        _state.value = state.value.copy(isButtonEnabled = isEnabled)
    }

    private fun login() {
        viewModelScope.launch {
            try {
                // TODO: val result = loginUseCase(state.value.email, state.value.password)

                val mockUserStatus = "createProfile"

                when (mockUserStatus) {
                    "createProfile" -> {
                        _effect.send(LoginContract.Effect.NavigateToCreateProfile)
                    }
                    "createAppPassword" -> {
                        _effect.send(LoginContract.Effect.NavigateToCreateAppPassword)
                    }
                }
            } catch (e: Exception) { } finally { }
        }
    }

}