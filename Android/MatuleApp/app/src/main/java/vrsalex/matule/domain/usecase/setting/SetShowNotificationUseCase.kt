package vrsalex.matule.domain.usecase.setting

import vrsalex.matule.data.local.datastore.AppSettingsManager
import javax.inject.Inject

class SetShowNotificationUseCase @Inject constructor(
    private val appSettingsManager: AppSettingsManager
) {

    suspend operator fun invoke(showNotification: Boolean)
        = appSettingsManager.saveShowNotification(showNotification)
}