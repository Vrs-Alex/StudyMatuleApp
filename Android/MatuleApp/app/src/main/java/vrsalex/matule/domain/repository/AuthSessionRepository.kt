package vrsalex.matule.domain.repository

import vrsalex.matule.domain.model.RegistrationData

interface AuthSessionRepository {

    fun saveLoginData(email: String, password: String)

    fun saveProfileData(
        firstName: String,
        lastName: String,
        patronymic: String,
        birthDate: String,
        gender: String,
        phoneNumber: String
    )

    fun savePhoneVerification(isPhoneVerified: Boolean)

    fun saveAppPassword(appPassword: String)

    fun getAuthData(): RegistrationData?

    fun clear()
}