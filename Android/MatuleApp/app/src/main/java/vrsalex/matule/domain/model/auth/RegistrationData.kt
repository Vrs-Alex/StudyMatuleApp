package vrsalex.matule.domain.model.auth

data class RegistrationData(
    val email: String = "",
    val password: String = "",
    val firstName: String = "" ,
    val lastName: String = "",
    val patronymic: String = "",
    val birthday: String = "",
    val gender: String = "",
    val phoneNum: String = ""
)
