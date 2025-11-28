package vrsalex.matuleapp.presentation.feature.auth

data class AuthUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)