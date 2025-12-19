package vrsalex.matule.data.remote.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val email: String,
    val password: String
)
