package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String?,
    val price: Int,
    @field:JsonProperty("typeCloses")
    val typeCloses: String?,
    val type: String?,
    @field:JsonProperty("approximateCost")
    val approximateCost: String?
)