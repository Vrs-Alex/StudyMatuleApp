package vrsalex.matule.data.local.mapper

import vrsalex.matule.data.local.database.entity.FullProjectInfo
import vrsalex.matule.data.local.database.entity.ProjectEntity
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.model.project.ProjectCategory
import vrsalex.matule.domain.model.project.ProjectType

fun FullProjectInfo.toDomain(): Project = Project(
    id = project.id,
    name = project.name,
    startDate = project.startDate,
    endDate = project.endDate,
    url = project.url,
    type = ProjectType(
        id = projectType.id,
        name = projectType.name,
        description = projectType.description
    ),
    category = ProjectCategory(
        id = projectCategory.id,
        name = projectCategory.name,
        description = projectCategory.description
    )
)

fun Project.toEntity(): ProjectEntity = ProjectEntity(
    id = id,
    name = name,
    startDate = startDate,
    endDate = endDate,
    url = url,
    typeId = type.id,
    categoryId = category.id
)