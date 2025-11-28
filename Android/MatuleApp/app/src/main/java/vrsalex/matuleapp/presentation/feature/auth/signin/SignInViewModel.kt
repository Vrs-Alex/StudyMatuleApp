package vrsalex.matuleapp.presentation.feature.auth.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {


    private val _uiState = MutableStateFlow(SignInUiState())
    val signInUiState: StateFlow<SignInUiState>
        get() = _uiState

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.EmailChanged -> {
                _uiState.value = _uiState.value.copy(email = event.value)
            }
            is SignInEvent.PasswordChanged -> {
                _uiState.value = _uiState.value.copy(password = event.value)
            }
            SignInEvent.LoginClicked -> login()
        }
    }

    private fun login(){

    }

}