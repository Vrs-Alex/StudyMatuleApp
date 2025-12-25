package vrsalex.matule.domain.model.project

sealed interface ProjectResult {
    data object Success : ProjectResult
    data class NetworkError(val message: String) : ProjectResult
    data class DatabaseError(val message: String) : ProjectResult
    data class UnknownError(val message: String) : ProjectResult
    data object SyncError : ProjectResult
}