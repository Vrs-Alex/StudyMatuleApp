package vrsalex.matule.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestOrderDto(
    @field:JsonProperty("user_id")
    val userId: String,
    @field:JsonProperty("product_id")
    val productId: String,
    val count: Int
)