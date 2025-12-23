package vrsalex.matule.domain.usecase.setting

import vrsalex.matule.data.local.datastore.AppSettingsManager
import javax.inject.Inject


class GetShowNotificationUseCase @Inject constructor(
    private val appSettingsManager: AppSettingsManager
){

    fun invoke() = appSettingsManager.getShowNotification()

}