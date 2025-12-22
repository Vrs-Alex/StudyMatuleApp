package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import vrsalex.matule.domain.model.auth.RegistrationData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthSessionRepositoryImpl @Inject constructor()  {

    val data = MutableStateFlow<RegistrationData?>(RegistrationData())

    fun clearData() {
        data.value = null
    }
}