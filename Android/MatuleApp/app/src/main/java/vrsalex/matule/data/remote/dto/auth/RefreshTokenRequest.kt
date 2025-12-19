package vrsalex.matule.data.remote.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    val token: String
)
