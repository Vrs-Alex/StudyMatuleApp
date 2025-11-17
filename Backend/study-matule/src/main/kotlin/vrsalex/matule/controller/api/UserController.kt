package vrsalex.matule.controller.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vrsalex.matule.dto.request.RequestAuthDto
import vrsalex.matule.dto.request.RequestRegisterDto
import vrsalex.matule.dto.request.RequestUserDto
import vrsalex.matule.dto.response.ResponseAuthDto
import vrsalex.matule.dto.response.ResponseRegisterDto
import vrsalex.matule.dto.response.UserDto
import vrsalex.matule.service.UserService

@RestController
@RequestMapping("/collections/users")
@Tag(name = "Пользователи", description = "Операции с пользователями (регистрация, аутентификация, профиль).")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/records")
    @Operation(summary = "Регистрация пользователя")
    fun register(@RequestBody request: RequestRegisterDto): ResponseEntity<ResponseRegisterDto> {
        val response = userService.registerUser(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PostMapping("/auth-with-password")
    @Operation(summary = "Аутентификация пользователя по паролю")
    fun authenticate(@RequestBody request: RequestAuthDto): ResponseEntity<ResponseAuthDto> {
        val response = userService.authenticateUser(request)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/records/{id_user}")
    @Operation(summary = "Получение информации о пользователе")
    fun getUserInfo(@PathVariable("id_user") idUser: String): ResponseEntity<UserDto> {
        val response = userService.getUserInfo(idUser)
        return ResponseEntity.ok(response)
    }

    @PatchMapping("/records/{id_user}")
    @Operation(summary = "Обновление профиля пользователя")
    fun updateProfile(
        @PathVariable("id_user") idUser: String,
        @RequestBody request: RequestUserDto
    ): ResponseEntity<UserDto> {
        // Здесь потребуется проверка токена для доступа к своему профилю
        val response = userService.updateProfile(idUser, request)
        return ResponseEntity.ok(response)
    }
}