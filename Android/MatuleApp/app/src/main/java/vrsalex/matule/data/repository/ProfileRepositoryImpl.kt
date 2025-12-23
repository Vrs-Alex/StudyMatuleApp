package vrsalex.matule.data.repository

import vrsalex.matule.data.local.datastore.SecuritySettingsManager
import vrsalex.matule.data.remote.api.ProfileApi
import vrsalex.matule.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApi: ProfileApi,
    private val securitySettingsManager: SecuritySettingsManager
): ProfileRepository {
    override suspend fun syncProfile() {
        try {
            val res = profileApi.getProfile()
            securitySettingsManager.saveUserName(res.firstName)
            securitySettingsManager.saveUserPhone(res.phoneNum)
        } catch (e: Exception) {

        }
    }
}