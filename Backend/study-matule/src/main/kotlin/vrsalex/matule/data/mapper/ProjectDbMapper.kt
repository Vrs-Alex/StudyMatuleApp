package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.ProjectEntity
import vrsalex.matule.domain.model.Project
import java.time.LocalDateTime
import java.util.UUID

fun ProjectEntity.toDomain(): Project = Project(
    id = this.id,
    title = this.title,
    dateStart = this.dateStart,
    dateEnd = this.dateEnd,
    gender = this.gender,
    descriptionSource = this.descriptionSource,
    category = this.category,
    image = this.image,
    userId = this.userId,
    created = this.createdAt,
    updated = this.updatedAt
)

fun Project.toEntity(isNew: Boolean = false): ProjectEntity = ProjectEntity(
    id = if (isNew) UUID.randomUUID().toString() else this.id,
    userId = this.userId,
    title = this.title,
    dateStart = this.dateStart,
    dateEnd = this.dateEnd,
    gender = this.gender,
    descriptionSource = this.descriptionSource,
    category = this.category,
    image = this.image,
    createdAt = if (isNew) LocalDateTime.now() else this.created,
    updatedAt = LocalDateTime.now()
)