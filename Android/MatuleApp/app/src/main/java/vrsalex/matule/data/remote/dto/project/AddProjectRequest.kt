package vrsalex.matule.data.remote.dto.project

import kotlinx.serialization.Serializable

@Serializable
data class AddProjectRequest(
    val id: Long?,
    val name: String,
    val startDate: String,
    val endDate: String,
    val url: String,
    val typeId: Long,
    val categoryId: Long
)
