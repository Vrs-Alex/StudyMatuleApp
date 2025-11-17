package vrsalex.matule.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
@Table(name = "projects")
data class ProjectEntity(
    @Id
    @Column(name = "id", nullable = false)
    @JvmField val id: String,

    @Column(name = "user_id", nullable = false)
    @JvmField val userId: String, // ID пользователя, создавшего проект

    @Column(name = "title", nullable = false)
    @JvmField val title: String,

    @Column(name = "date_start")
    @JvmField val dateStart: String? = null,

    @Column(name = "date_end")
    @JvmField val dateEnd: String? = null,

    @Column(name = "gender")
    @JvmField val gender: String? = null,

    @Column(name = "description_source", length = 1000)
    @JvmField val descriptionSource: String? = null,

    @Column(name = "category")
    @JvmField val category: String? = null,

    @Column(name = "image")
    @JvmField val image: String? = null, // URL или путь к изображению

    @Column(name = "created_at", nullable = false)
    @JvmField val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @JvmField var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this("", "", "")
}