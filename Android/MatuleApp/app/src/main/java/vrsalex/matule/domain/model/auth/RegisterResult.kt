package vrsalex.matule.domain.model.auth

sealed interface RegisterResult {

    data object Success : RegisterResult // 202

    data object UserAlreadyExists : RegisterResult // 409

    data class Error(val error: String) : RegisterResult

    companion object {
        fun fromCode(code: Int) = when (code) {
            202 -> Success
            409 -> UserAlreadyExists
            else -> Error("Unknown error")
        }
    }

}