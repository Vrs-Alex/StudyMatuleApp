package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import vrsalex.matule.domain.model.RegistrationData
import vrsalex.matule.domain.repository.AuthSessionRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthSessionRepositoryImpl @Inject constructor()
    : AuthSessionRepository  {

    private val _state = MutableStateFlow<RegistrationData?>(RegistrationData())

    override fun saveLoginData(email: String, password: String){
        _state.value = RegistrationData(email = email, accountPassword = password)
    }

    override fun saveProfileData(
        firstName: String,
        lastName: String,
        patronymic: String,
        birthDate: String,
        gender: String,
        phoneNumber: String
    ){
        _state.value = _state.value?.copy(
            firstName = firstName,
            lastName = lastName,
            patronymic = patronymic,
            birthDate = birthDate,
            gender = gender,
            phoneNumber = phoneNumber
        )
    }

    override fun savePhoneVerification(isPhoneVerified: Boolean){
        _state.value = _state.value?.copy(isPhoneVerified = isPhoneVerified)
    }

    override fun saveAppPassword(appPassword: String){
        _state.value = _state.value?.copy(appPassword = appPassword)
    }

    override fun getAuthData() = _state.value


    override fun clear(){
        _state.value = null
    }

}