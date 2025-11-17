package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseOrderDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    @field:JsonProperty("user_id")
    val userId: String,
    @field:JsonProperty("product_id")
    val productId: String,
    val count: Int
)