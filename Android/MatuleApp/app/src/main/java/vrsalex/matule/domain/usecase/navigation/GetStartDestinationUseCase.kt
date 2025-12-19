package vrsalex.matule.domain.usecase.navigation

import kotlinx.coroutines.flow.first
import vrsalex.matule.data.local.datastore.AppSettingManager
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.domain.repository.AuthRepository
import vrsalex.matule.presentation.auth.AuthGraph
import vrsalex.matule.presentation.home.HomeGraph
import vrsalex.matule.presentation.setting.VerifyPinCodeDestination
import javax.inject.Inject

class GetStartDestinationUseCase @Inject constructor(
    private val tokenManager: TokenManager,
    private val appSettingManager: AppSettingManager
) {

    suspend operator fun invoke(): Any {
        if (appSettingManager.getPinCode().first() != null)
            return VerifyPinCodeDestination
        if (tokenManager.isHaveTokens())
            return HomeGraph
        return AuthGraph
    }

}