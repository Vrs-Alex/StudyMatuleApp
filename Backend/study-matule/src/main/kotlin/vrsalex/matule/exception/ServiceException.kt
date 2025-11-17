package vrsalex.matule.exception

import org.springframework.http.HttpStatus

class ServiceException(
    val status: HttpStatus,
    override val message: String
) : RuntimeException(message)