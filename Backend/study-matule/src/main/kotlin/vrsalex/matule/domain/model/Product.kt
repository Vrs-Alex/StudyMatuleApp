package vrsalex.matule.domain.model

import java.time.LocalDateTime


data class Product(
    val id: String,
    val title: String,
    val description: String?,
    val price: Int,
    val typeCloses: String?,
    val type: String?,
    val approximateCost: String?,
    val created: LocalDateTime,
    val updated: LocalDateTime
)