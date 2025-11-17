package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ProjectDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    @field:JsonProperty("dateStart")
    val dateStart: String?,
    @field:JsonProperty("dateEnd")
    val dateEnd: String?,
    val gender: String?,
    @field:JsonProperty("description_source")
    val descriptionSource: String?,
    val category: String?,
    val image: String?,
    @field:JsonProperty("user_id")
    val userId: String
)