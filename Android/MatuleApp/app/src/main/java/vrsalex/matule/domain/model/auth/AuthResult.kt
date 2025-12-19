package vrsalex.matule.domain.model.auth

sealed interface AuthResult {
    data object Success : AuthResult
    data object UserNotFound : AuthResult
    data object InvalidCredentials : AuthResult
    data class Error(val message: String) : AuthResult
}