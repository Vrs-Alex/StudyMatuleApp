package vrsalex.matule.data.remote.dto.profile

import kotlinx.serialization.Serializable

@Serializable
data class ProfileDataResponse(
    val email: String,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val birthday: String,
    val gender: String,
    val phoneNum: String
)
