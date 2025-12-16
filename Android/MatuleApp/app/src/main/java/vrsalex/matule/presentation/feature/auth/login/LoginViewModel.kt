package vrsalex.matule.presentation.feature.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import vrsalex.matule.data.repository.AuthSessionRepository
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authSessionRepository: AuthSessionRepository
): ViewModel() {

    private val _state = MutableStateFlow(LoginContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<LoginContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: LoginContract.Event) {
        when(event){
            is LoginContract.Event.OnClick -> {
                login()
            }
            is LoginContract.Event.EmailChanged -> {
                _state.value = state.value.copy(email = event.email)
                isButtonEnabled()
            }
            is LoginContract.Event.PasswordChanged -> {
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

                authSessionRepository.saveLoginData(state.value.email, state.value.password)
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