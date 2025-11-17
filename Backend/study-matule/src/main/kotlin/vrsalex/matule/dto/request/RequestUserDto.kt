package vrsalex.matule.dto.request

data class RequestUserDto(
    val email: String?,
    val emailVisibility: Boolean?,
    val firstname: String?,
    val lastname: String?,
    val secondname: String?,
    val datebirthday: String?, // Дату лучше хранить как LocalDate, но по контракту пока String
    val gender: String?
)