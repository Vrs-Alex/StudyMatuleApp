package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductItemDto(
    val id: String,
    val title: String,
    val price: Int,
    @field:JsonProperty("typeCloses")
    val typeCloses: String?,
    val type: String?
)
