package vrsalex.matule.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
@Table(name = "news")
data class NewsEntity(
    @Id
    @Column(name = "id", nullable = false)
    @JvmField val id: String,

    @Column(name = "news_image")
    @JvmField val newsImage: String? = null, // URL или путь к изображению

    @Column(name = "created_at", nullable = false)
    @JvmField val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @JvmField var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this("")
}