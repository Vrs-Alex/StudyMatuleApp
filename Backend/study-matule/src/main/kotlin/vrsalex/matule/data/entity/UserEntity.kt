package vrsalex.matule.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    // В вашем YAML ID имеет тип string. Используем UUID или String,
    // если он генерируется внешне. Для простоты симуляции пока оставим String
    @Column(name = "id", nullable = false)
    @JvmField val id: String,

    @Column(name = "email", unique = true, nullable = false)
    @JvmField val email: String,

    @Column(name = "password_hash", nullable = false) // Пароль хранится в хэшированном виде
    @JvmField var passwordHash: String, // Пароль нужен только на уровне Entity/Service для аутентификации

    @Column(name = "email_visibility")
    @JvmField var emailVisibility: Boolean = false,

    @Column(name = "firstname")
    @JvmField var firstname: String? = null,

    @Column(name = "lastname")
    @JvmField var lastname: String? = null,

    @Column(name = "secondname")
    @JvmField var secondname: String? = null,

    @Column(name = "date_birthday")
    @JvmField var dateBirthday: String? = null, // Сохраняем как String по контракту, но лучше LocalDate

    @Column(name = "gender")
    @JvmField var gender: String? = null,

    @Column(name = "verified")
    @JvmField var verified: Boolean = false,

    @Column(name = "created_at", nullable = false)
    @JvmField val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @JvmField var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    // JPA требует no-arg constructor
    constructor() : this("", "", "")
}