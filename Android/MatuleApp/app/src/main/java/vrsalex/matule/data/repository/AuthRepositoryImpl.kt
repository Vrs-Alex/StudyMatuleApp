package vrsalex.matule.data.repository

import retrofit2.HttpException
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.data.remote.api.AuthApi
import vrsalex.matule.data.remote.dto.auth.SignInRequest
import vrsalex.matule.data.remote.dto.auth.SignUpRequest
import vrsalex.matule.data.remote.dto.auth.VerifySignUpRequest
import vrsalex.matule.domain.model.auth.LoginResult
import vrsalex.matule.domain.model.auth.RegisterResult
import vrsalex.matule.domain.model.auth.RegistrationData
import vrsalex.matule.domain.model.auth.VerifyResult
import vrsalex.matule.domain.repository.AuthRepository
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        return try {
            val response = authApi.login(SignInRequest(email,password))

            tokenManager.saveAccessToken(response.accessToken)
            tokenManager.saveRefreshToken(response.refreshToken)

            LoginResult.Success
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> LoginResult.InvalidCredentials
                406 -> LoginResult.UserNotFound
                else -> LoginResult.Error("Ошибка сервера: ${e.code()}")
            }
        } catch (e: Exception) {
            LoginResult.Error("Проблемы с сетью")
        }
    }

    override suspend fun register(data: RegistrationData): RegisterResult {
        return try {
            val request = SignUpRequest(
                email = data.email,
                password = data.password,
                firstName = data.firstName,
                lastName = data.lastName,
                patronymic = data.patronymic,
                birthday = data.birthday,
                gender = data.gender,
                phoneNum = data.phoneNum
            )
            val response = authApi.register(request)
            RegisterResult.Success
        } catch (e: HttpException){
            RegisterResult.fromCode(e.code())
        }catch (e: Exception){
            RegisterResult.Error(e.toString())
        }
    }

    override suspend fun verify(
        phone: String,
        code: String
    ): VerifyResult {
        return try {
            val response = authApi.verify(VerifySignUpRequest(phone, code.toInt()))

            tokenManager.saveAccessToken(response.accessToken)
            tokenManager.saveRefreshToken(response.refreshToken)

            VerifyResult.Success
        } catch (e: HttpException){
            VerifyResult.fromCode(e.code())
        } catch (e: IOException){
            VerifyResult.Error(e.message.toString())
        }
    }
}