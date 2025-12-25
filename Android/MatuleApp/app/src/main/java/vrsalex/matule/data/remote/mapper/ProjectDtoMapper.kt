package vrsalex.matule.data.remote.mapper

import vrsalex.matule.data.remote.dto.project.AddProjectRequest
import vrsalex.matule.data.remote.dto.project.ProjectCategoryResponse
import vrsalex.matule.data.remote.dto.project.ProjectResponse
import vrsalex.matule.data.remote.dto.project.ProjectTypeResponse
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.model.project.ProjectCategory
import vrsalex.matule.domain.model.project.ProjectType


fun ProjectTypeResponse.toDomain() = ProjectType(
    id = this.id,
    name = this.name,
    description = this.description
)

fun ProjectCategoryResponse.toDomain() = ProjectCategory(
    id = this.id,
    name = this.name,
    description = this.description
)



fun ProjectResponse.toDomain() = Project(
    id = this.id,
    name = this.name,
    startDate = this.startDate,
    endDate = this.endDate,
    url = this.url,
    type = this.type.toDomain(),
    category = this.category.toDomain()
)


fun Project.toAddRequest() = AddProjectRequest(
    id = this.id,
    name = this.name,
    startDate = this.startDate,
    endDate = this.endDate,
    url = this.url,
    typeId = this.type!!.id,
    categoryId = this.category!!.id,
)