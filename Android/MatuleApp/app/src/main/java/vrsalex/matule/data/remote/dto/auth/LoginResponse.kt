package vrsalex.matule.data.remote.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(val accessToken: String, val refreshToken: String)