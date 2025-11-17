package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UserAuthDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    @field:JsonProperty("collectionRef")
    val collectionRef: String?,
    val fingerprint: String?,
    @field:JsonProperty("recordRef")
    val recordRef: String?
)