package vrsalex.matule.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class RequestRegisterDto(
    @field:Email
    @field:NotBlank
    val email: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    @field:JsonProperty("passwordConfirm") // YAML использует passwordConfirm
    val passwordConfirm: String
)