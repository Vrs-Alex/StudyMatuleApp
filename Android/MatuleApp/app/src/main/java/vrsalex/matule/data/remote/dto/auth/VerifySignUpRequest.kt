package vrsalex.matule.data.remote.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class VerifySignUpRequest(
    val phoneNumber: String,
    val code: Int
)
