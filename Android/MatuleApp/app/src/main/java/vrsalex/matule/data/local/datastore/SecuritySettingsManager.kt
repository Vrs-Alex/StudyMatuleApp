package vrsalex.matule.data.local.datastore

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SecuritySettingsManager @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {

    suspend fun savePinCode(pinCode: String) = dataStoreManager.savePinCode(pinCode)

    fun getPinCode(): Flow<String?> = dataStoreManager.getPinCode()

    suspend fun saveUserName(name: String) = dataStoreManager.saveUserName(name)

    fun getUserName() = dataStoreManager.getUserName()

    suspend fun saveUserPhone(phone: String) = dataStoreManager.saveUserPhone(phone)

    fun getUserPhone() = dataStoreManager.getUserPhone()

    suspend fun clearAll() = dataStoreManager.clearAll()

}