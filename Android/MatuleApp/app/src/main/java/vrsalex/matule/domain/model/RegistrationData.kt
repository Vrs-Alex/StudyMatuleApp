package vrsalex.matule.domain.model

data class RegistrationData(
    val email: String = "",
    val accountPassword: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val patronymic: String = "",
    val birthDate: String = "",
    val gender: String = "",
    val phoneNumber: String = "",
    val isPhoneVerified: Boolean = false,
    val appPassword: String? = null
)
