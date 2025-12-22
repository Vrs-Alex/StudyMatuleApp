package vrsalex.matule.domain.model.auth

sealed interface VerifyResult {

    data object Success : VerifyResult // 200
    data object TimeExpired : VerifyResult // 401
    data class Error(val error: String) : VerifyResult

    companion object {
        fun fromCode(code: Int) = when (code) {
            200 -> Success
            401 -> TimeExpired
            else -> Error("Unknown error")
        }
    }

}