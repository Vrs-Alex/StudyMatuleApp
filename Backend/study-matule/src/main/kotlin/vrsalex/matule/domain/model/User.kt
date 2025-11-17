package vrsalex.matule.domain.model

import java.time.LocalDateTime

data class User(
    val id: String,
    val email: String,
    val emailVisibility: Boolean,
    val passwordHash: String,
    val firstname: String?,
    val lastname: String?,
    val secondname: String?,
    val datebirthday: String?, // В идеале использовать LocalDate
    val gender: String?,
    val verified: Boolean,
    val created: LocalDateTime,
    val updated: LocalDateTime
)