package vrsalex.matule.dto.request

import jakarta.validation.constraints.NotBlank

data class RequestAuthDto(
    @field:NotBlank
    val identity: String, // Может быть email или username
    @field:NotBlank
    val password: String
)