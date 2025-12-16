package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vrsalex.matule.domain.model.RegistrationData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthSessionRepository @Inject constructor() {

    private val _state = MutableStateFlow<RegistrationData?>(RegistrationData())

    fun saveLoginData(email: String, password: String){
        _state.value = RegistrationData(email = email, accountPassword = password)
    }

    fun saveProfileData(
        firstName: String,
        lastName: String,
        patronymic: String,
        birthDate: String,
        gender: String,
        phoneNumber: String
    ){
        _state.value?.copy(
            firstName = firstName,
            lastName = lastName,
            patronymic = patronymic,
            birthDate = birthDate,
            gender = gender,
            phoneNumber = phoneNumber
        )
    }

    fun savePhoneVerification(isPhoneVerified: Boolean){
        _state.value?.copy(isPhoneVerified = isPhoneVerified)
    }

    fun saveAppPassword(appPassword: String){
        _state.value?.copy(appPassword = appPassword)
    }

    fun getAuthData() = _state.value


    fun clear(){
        _state.value = null
    }

}