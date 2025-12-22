package vrsalex.matule.domain.usecase.navigation

import kotlinx.coroutines.flow.first
import vrsalex.matule.data.local.datastore.AppSettingManager
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.presentation.auth.navigation.AuthGraph
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph
import vrsalex.matule.presentation.setting.VerifyPinCodeDestination
import javax.inject.Inject

class GetStartDestinationUseCase @Inject constructor(
    private val tokenManager: TokenManager,
    private val appSettingManager: AppSettingManager
) {

    suspend operator fun invoke(): Any {
        val hasTokens = tokenManager.isHaveTokens()
        if (appSettingManager.getPinCode().first() != null
            && !hasTokens)
            return VerifyPinCodeDestination
        if (hasTokens)
            return BottomTabsGraph
        return AuthGraph
    }

}