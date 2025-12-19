package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.Flow
import vrsalex.matule.data.local.datastore.AppSettingManager
import vrsalex.matule.data.local.datastore.TokenManager
import vrsalex.matule.domain.repository.AppSettingRepository
import javax.inject.Inject

class AppSettingRepositoryImpl @Inject constructor(
    private val appSettingManager: AppSettingManager
): AppSettingRepository {

    override suspend fun savePinCode(pinCode: String) {
        appSettingManager.savePinCode(pinCode)
    }

    override fun getPinCode(): Flow<String?> =
        appSettingManager.getPinCode()


}