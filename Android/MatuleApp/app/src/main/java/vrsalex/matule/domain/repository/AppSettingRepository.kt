package vrsalex.matule.domain.repository

import kotlinx.coroutines.flow.Flow

interface AppSettingRepository {

    suspend fun savePinCode(pinCode: String)

    fun getPinCode(): Flow<String?>

}