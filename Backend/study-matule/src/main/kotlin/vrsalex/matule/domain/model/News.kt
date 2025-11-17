package vrsalex.matule.domain.model

import java.time.LocalDateTime

data class News(
    val id: String,
    val newsImage: String?,
    val created: LocalDateTime,
    val updated: LocalDateTime
)