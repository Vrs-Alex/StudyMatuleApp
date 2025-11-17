package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class NewsDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    @field:JsonProperty("newsImage")
    val newsImage: String?
)