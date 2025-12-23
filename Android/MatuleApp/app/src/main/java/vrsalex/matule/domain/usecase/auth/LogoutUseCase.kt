package vrsalex.matule.domain.usecase.auth

import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.domain.repository.AuthEventRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authEventRepository: AuthEventRepository
) {

    suspend operator fun invoke(){
        authEventRepository.logout()
    }

}