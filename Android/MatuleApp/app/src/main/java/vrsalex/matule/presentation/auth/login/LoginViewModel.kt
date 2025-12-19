package vrsalex.matule.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vrsalex.matule.domain.model.auth.AuthResult
import vrsalex.matule.domain.usecase.auth.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<LoginContract.State>(LoginContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<LoginContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: LoginContract.Event) {
        when(event){
            is LoginContract.Event.EmailChanged -> { _state.update { it.copy(email = event.email) } }
            is LoginContract.Event.PasswordChanged -> { _state.update { it.copy(password = event.password) } }
            LoginContract.Event.LoginClicked -> { login() }
        }
    }

    private fun login() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true)}
        val result = loginUseCase(state.value.email, state.value.password)
        _state.update { it.copy(isLoading = false)}
        when(result){
            AuthResult.Success -> {
                _effect.send(LoginContract.Effect.OnLogin)
            }
            AuthResult.InvalidCredentials -> {

            }
            AuthResult.UserNotFound -> {
                _effect.send(LoginContract.Effect.OnRegister)
            }
            is AuthResult.Error -> {

            }
        }
    }

}