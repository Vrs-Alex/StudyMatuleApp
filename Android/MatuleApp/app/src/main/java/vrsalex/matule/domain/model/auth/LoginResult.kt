package vrsalex.matule.domain.model.auth

sealed interface LoginResult {
    data object Success : LoginResult
    data object UserNotFound : LoginResult
    data object InvalidCredentials : LoginResult
    data class Error(val message: String) : LoginResult
}