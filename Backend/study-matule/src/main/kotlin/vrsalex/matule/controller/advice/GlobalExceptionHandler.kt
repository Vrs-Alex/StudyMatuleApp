package vrsalex.matule.controller.advice

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import vrsalex.matule.dto.response.Error400Dto
import vrsalex.matule.exception.ServiceException

@RestControllerAdvice
@Hidden
class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException::class)
    fun handleServiceException(ex: ServiceException): ResponseEntity<Error400Dto> {
        val errorDto = Error400Dto(
            status = ex.status.value(),
            message = ex.message,
            data = mapOf("errorType" to ex.status.reasonPhrase)
        )
        // Возвращаем соответствующий HTTP статус
        return ResponseEntity.status(ex.status).body(errorDto)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<Error400Dto> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorDto = Error400Dto(
            status = status.value(),
            message = "Internal Server Error. Please contact support.",
            data = mapOf("details" to (ex.message ?: "Unknown error"))
        )
        return ResponseEntity.status(status).body(errorDto)
    }
}