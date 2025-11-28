package vrsalex.matuleapp.presentation.feature.auth.signin

data class SignInUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)