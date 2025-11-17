package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.UserEntity
import vrsalex.matule.domain.model.User
import java.time.LocalDateTime

fun UserEntity.toDomain(): User = User(
    id = this.id,
    email = this.email,
    emailVisibility = this.emailVisibility,
    firstname = this.firstname,
    lastname = this.lastname,
    secondname = this.secondname,
    datebirthday = this.dateBirthday,
    gender = this.gender,
    verified = this.verified,
    created = this.createdAt,
    updated = this.updatedAt,
    passwordHash = this.passwordHash
)

fun User.toEntity(isNew: Boolean = false): UserEntity = UserEntity(
    id = this.id,
    email = this.email,
    passwordHash = passwordHash,
    emailVisibility = this.emailVisibility,
    firstname = this.firstname,
    lastname = this.lastname,
    secondname = this.secondname,
    dateBirthday = this.datebirthday,
    gender = this.gender,
    verified = this.verified,
    createdAt = if (isNew) LocalDateTime.now() else this.created,
    updatedAt = LocalDateTime.now()
)