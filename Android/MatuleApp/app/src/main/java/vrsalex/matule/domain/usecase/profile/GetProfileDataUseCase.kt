package vrsalex.matule.domain.usecase.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import vrsalex.matule.data.local.datastore.AppSettingsManager
import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.domain.model.profile.ProfileData
import vrsalex.matule.domain.repository.AppSettingRepository
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor(
    private val appSettingManager: AppSettingsManager,
    private val securitySettingsManager: SecuritySettingsManager
) {

    operator fun invoke(): Flow<ProfileData> = combine(
            appSettingManager.getShowNotification(),
            securitySettingsManager.getUserName(),
            securitySettingsManager.getUserPhone())
    { showNotification, name, phone ->
        ProfileData(
            name = name ?: "",
            phone = phone ?: "",
            isShowNotification = showNotification ?: false
        )
    }

}