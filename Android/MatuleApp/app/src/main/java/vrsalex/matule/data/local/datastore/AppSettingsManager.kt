package vrsalex.matule.data.local.datastore

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSettingsManager @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {

    suspend fun saveShowNotification(showNotification: Boolean)
        = dataStoreManager.saveShowNotification(showNotification)

    fun getShowNotification(): Flow<Boolean?>
        = dataStoreManager.getShowNotification()

}