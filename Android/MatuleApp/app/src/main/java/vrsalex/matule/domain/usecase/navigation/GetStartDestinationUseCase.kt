package vrsalex.matule.domain.usecase.navigation

import kotlinx.coroutines.flow.first
import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.presentation.auth.navigation.AuthGraph
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph
import vrsalex.matule.presentation.setting.VerifyPinCodeDestination
import javax.inject.Inject

class GetStartDestinationUseCase @Inject constructor(
    private val tokenManager: TokenManager,
    private val securitySettingsManager: SecuritySettingsManager
) {

    suspend operator fun invoke(): Any {
        val hasTokens = tokenManager.isHaveTokens()
        if (securitySettingsManager.getPinCode().first() != null
            && hasTokens)
            return VerifyPinCodeDestination
        if (hasTokens)
            return BottomTabsGraph
        return AuthGraph
    }

}