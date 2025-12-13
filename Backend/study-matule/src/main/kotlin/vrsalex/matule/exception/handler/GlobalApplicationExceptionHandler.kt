package vrsalex.matule.exception.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import vrsalex.matule.application.exception.MyApplicationException
import vrsalex.matule.exception.ErrorResponse

@RestControllerAdvice
class GlobalApplicationExceptionHandler {


    @ExceptionHandler(MyApplicationException::class)
    fun handleApplicationException(ex: MyApplicationException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = ex.errorCode,
            message = ex.message ?: "Invalid input data."
        )
        return ResponseEntity(errorResponse, HttpStatus.valueOf(ex.errorCode))
    }

}
