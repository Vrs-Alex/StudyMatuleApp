package vrsalex.matule.dto.response

data class Error400Dto(
    val status: Int,
    val message: String,
    val data: Map<String, Any>? = null // data - это произвольный объект
)