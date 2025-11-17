package vrsalex.matule.domain.model

import java.time.LocalDateTime

data class CartItem(
    val id: String,
    val userId: String,
    val productId: String,
    val count: Int,
    val created: LocalDateTime,
    val updated: LocalDateTime
)