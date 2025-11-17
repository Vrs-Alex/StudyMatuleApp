package vrsalex.matule.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "cart_items")
data class CartItemEntity(
    @Id
    @Column(name = "id", nullable = false)
    @JvmField val id: String,

    @Column(name = "user_id", nullable = false)
    @JvmField val userId: String,

    @Column(name = "product_id", nullable = false)
    @JvmField val productId: String,

    @Column(name = "count", nullable = false)
    @JvmField var count: Int,

    @Column(name = "created_at", nullable = false)
    @JvmField val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @JvmField var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this("", "", "", 0)
}