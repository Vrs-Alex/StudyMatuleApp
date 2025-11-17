package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UsersAuthDto(
    val page: Int,
    @field:JsonProperty("perPage")
    val perPage: Int,
    @field:JsonProperty("totalPages")
    val totalPages: Int,
    @field:JsonProperty("totalItems")
    val totalItems: Int,
    val items: List<UserAuthDto>
)