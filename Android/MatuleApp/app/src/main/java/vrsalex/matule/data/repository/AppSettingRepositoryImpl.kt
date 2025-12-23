package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.Flow
import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.domain.repository.AppSettingRepository
import javax.inject.Inject

class AppSettingRepositoryImpl @Inject constructor(
    private val securitySettingsManager: SecuritySettingsManager
): AppSettingRepository {

    override suspend fun savePinCode(pinCode: String) {
        securitySettingsManager.savePinCode(pinCode)
    }

    override fun getPinCode(): Flow<String?> =
        securitySettingsManager.getPinCode()


}