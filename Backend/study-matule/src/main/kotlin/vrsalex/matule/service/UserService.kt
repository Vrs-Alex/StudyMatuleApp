package vrsalex.matule.service


import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import vrsalex.matule.domain.model.User
import vrsalex.matule.domain.port.repository.UserRepository
import vrsalex.matule.dto.request.RequestAuthDto
import vrsalex.matule.dto.request.RequestRegisterDto
import vrsalex.matule.dto.request.RequestUserDto
import vrsalex.matule.dto.response.ResponseAuthDto
import vrsalex.matule.dto.response.ResponseRegisterDto
import vrsalex.matule.dto.response.UserDto
import vrsalex.matule.exception.ServiceException
import java.time.LocalDateTime
import java.util.UUID


@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    private fun User.toDto(): UserDto = UserDto(
        id = id,
        collectionId = "user",
        collectionName = "users",
        created = created.toString(),
        updated = updated.toString(),
        email = email,
        emailVisibility = emailVisibility,
        firstname = firstname,
        lastname = lastname,
        secondname = secondname,
        dateBirthday = datebirthday,
        gender = gender,
        verified = verified
    )

    private fun User.toRegisterDto(): ResponseRegisterDto = ResponseRegisterDto(
        id = id,
        collectionId = "user",
        collectionName = "users",
        created = created.toString(),
        updated = updated.toString(),
        emailVisibility = emailVisibility,
        firstname = firstname,
        lastname = lastname,
        secondname = secondname,
        dateBirthday = datebirthday,
        gender = gender,
        verified = verified
    )

    private fun generateAuthToken(userId: String): String {
        return "fake_token_for_user_$userId-${System.currentTimeMillis()}"
    }

    // -----------------------------------------------------------------

    /**
     * POST /collections/users/records: Регистрация нового пользователя.
     */
    fun registerUser(request: RequestRegisterDto): ResponseRegisterDto {
        if (userRepository.findByEmail(request.email) != null) {
            throw ServiceException(HttpStatus.BAD_REQUEST, "User with email ${request.email} already exists.")
        }

        if (request.password != request.passwordConfirm) {
            throw ServiceException(HttpStatus.BAD_REQUEST, "Password and passwordConfirm do not match.")
        }

        val creationTime = LocalDateTime.now()
        val hashedPassword = passwordEncoder.encode(request.password)

        val newUserDomain = User(
            id = UUID.randomUUID().toString(),
            email = request.email,
            passwordHash = hashedPassword,
            emailVisibility = true,
            firstname = null, lastname = null, secondname = null,
            datebirthday = null, gender = null, verified = false,
            created = creationTime,
            updated = creationTime
        )

        val savedUser = userRepository.save(newUserDomain)

        return savedUser.toRegisterDto()
    }

    /**
     * POST /collections/users/auth-with-password: Аутентификация пользователя.
     */
    fun authenticateUser(request: RequestAuthDto): ResponseAuthDto {
        val user = userRepository.findByEmail(request.identity)
            ?: throw ServiceException(HttpStatus.UNAUTHORIZED, "Invalid credentials or user not found.")
        println(user)
        // Проверка пароля с использованием PasswordEncoder и хэша из Domain-модели
        if (!passwordEncoder.matches(request.password, user.passwordHash)) {
            throw ServiceException(HttpStatus.UNAUTHORIZED, "Invalid password.")
        }

        // Генерация токена-заглушки
        val token = generateAuthToken(user.id)

        return ResponseAuthDto(
            record = user.toDto(),
            token = token
        )
    }

    /**
     * GET /collections/users/records/{id_user}: Получение информации о пользователе.
     */
    fun getUserInfo(idUser: String): UserDto {
        val user = userRepository.findById(idUser)
            ?: throw ServiceException(HttpStatus.NOT_FOUND, "User not found.")
        return user.toDto()
    }

    /**
     * PATCH /collections/users/records/{id_user}: Изменение профиля.
     */
    fun updateProfile(idUser: String, request: RequestUserDto): UserDto {
        val existingUser = userRepository.findById(idUser)
            ?: throw ServiceException(HttpStatus.NOT_FOUND, "User not found for update.")

        // Обновление полей. passwordHash сохраняется из existingUser.
        val updatedDomain = existingUser.copy(
            email = request.email ?: existingUser.email,
            emailVisibility = request.emailVisibility ?: existingUser.emailVisibility,
            firstname = request.firstname ?: existingUser.firstname,
            lastname = request.lastname ?: existingUser.lastname,
            secondname = request.secondname ?: existingUser.secondname,
            datebirthday = request.datebirthday ?: existingUser.datebirthday,
            gender = request.gender ?: existingUser.gender,
            updated = LocalDateTime.now()
        )

        val savedUser = userRepository.update(updatedDomain)
        return savedUser.toDto()
    }
}