package vrsalex.matule.data.local.mapper

import vrsalex.matule.data.local.database.entity.FullProjectInfo
import vrsalex.matule.data.local.database.entity.ProjectCategoryEntity
import vrsalex.matule.data.local.database.entity.ProjectEntity
import vrsalex.matule.data.local.database.entity.ProjectTypeEntity
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.model.project.ProjectCategory
import vrsalex.matule.domain.model.project.ProjectType

fun FullProjectInfo.toDomain(): Project = Project(
    id = project.id,
    name = project.name,
    startDate = project.startDate,
    endDate = project.endDate,
    url = project.url,
    type = projectType?.let {
        ProjectType(
            id = projectType.id,
            name = projectType.name,
            description = projectType.description)
                            },
    category = projectCategory?.let {
        ProjectCategory(
            id = projectCategory.id,
            name = projectCategory.name,
            description = projectCategory.description
        )
    }
)

fun Project.toEntity(): ProjectEntity = ProjectEntity(
    id = id,
    name = name,
    startDate = startDate,
    endDate = endDate,
    url = url,
    typeId = type!!.id,
    categoryId = category!!.id
)


fun ProjectType.toEntity() = ProjectTypeEntity(
    id = id,
    name = name,
    description = description
)

fun ProjectCategory.toEntity() = ProjectCategoryEntity(
    id = id,
    name = name,
    description = description
)