package vrsalex.matule.data.remote.dto.project

import kotlinx.serialization.Serializable

@Serializable
data class ProjectCategoryResponse(
    val id: Long,
    val name: String,
    val description: String?
)