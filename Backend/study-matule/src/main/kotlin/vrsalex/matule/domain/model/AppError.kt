package vrsalex.matule.domain.model

data class AppError(
    val status: Int,
    val message: String,
    val data: Map<String, Any>? = null // Для дополнительных данных ошибки
)