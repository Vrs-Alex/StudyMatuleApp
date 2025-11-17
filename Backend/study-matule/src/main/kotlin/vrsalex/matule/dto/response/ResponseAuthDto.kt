package vrsalex.matule.dto.response

data class ResponseAuthDto(
    val record: UserDto,
    val token: String
)