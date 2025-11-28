package vrsalex.matuleapp.presentation.feature.auth

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {


    private val _uiState = MutableStateFlow(AuthUiState())
    val authUiState: StateFlow<AuthUiState>
        get() = _uiState

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.EmailChanged -> {
                _uiState.value = _uiState.value.copy(email = event.value)
            }
            is AuthEvent.PasswordChanged -> {
                _uiState.value = _uiState.value.copy(password = event.value)
            }
            AuthEvent.LoginClicked -> login()
        }
    }

    private fun login(){

    }

}