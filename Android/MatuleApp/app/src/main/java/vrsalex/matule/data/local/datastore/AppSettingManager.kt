package vrsalex.matule.data.local.datastore

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AppSettingManager @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {

    suspend fun savePinCode(pinCode: String) = dataStoreManager.savePinCode(pinCode)

    fun getPinCode(): Flow<String?> = dataStoreManager.getPinCode()

    suspend fun clearAll() = dataStoreManager.clearAll()

}