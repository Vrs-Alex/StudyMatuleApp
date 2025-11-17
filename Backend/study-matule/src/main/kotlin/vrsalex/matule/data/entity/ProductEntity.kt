package vrsalex.matule.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @Column(name = "id", nullable = false)
    @JvmField val id: String,

    @Column(name = "title", nullable = false)
    @JvmField val title: String,

    @Column(name = "description", length = 1000)
    @JvmField val description: String? = null,

    @Column(name = "price", nullable = false)
    @JvmField val price: Int,

    @Column(name = "type_closes")
    @JvmField val typeCloses: String? = null,

    @Column(name = "type")
    @JvmField val type: String? = null,

    @Column(name = "approximate_cost")
    @JvmField val approximateCost: String? = null,

    @Column(name = "created_at", nullable = false)
    @JvmField val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @JvmField var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this("", "", "", 0)
}