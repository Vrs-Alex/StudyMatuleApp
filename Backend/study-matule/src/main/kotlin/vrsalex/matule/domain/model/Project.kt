package vrsalex.matule.domain.model

import java.time.LocalDateTime

data class Project(
    val id: String,
    val title: String,
    val dateStart: String?,
    val dateEnd: String?,
    val gender: String?,
    val descriptionSource: String?,
    val category: String?,
    val image: String?, // Путь к файлу или URL
    val userId: String,
    val created: LocalDateTime,
    val updated: LocalDateTime
)