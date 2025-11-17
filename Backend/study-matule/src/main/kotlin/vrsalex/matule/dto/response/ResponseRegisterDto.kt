package vrsalex.matule.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseRegisterDto(
    val id: String,
    @field:JsonProperty("collectionId")
    val collectionId: String,
    @field:JsonProperty("collectionName")
    val collectionName: String,
    val created: String,
    val updated: String,
    @field:JsonProperty("emailVisibility")
    val emailVisibility: Boolean,
    val firstname: String?,
    val lastname: String?,
    val secondname: String?,
    @field:JsonProperty("datebirthday")
    val dateBirthday: String?,
    val gender: String?,
    val verified: Boolean
)