package vrsalex.matule.data.repository

import vrsalex.matule.data.remote.api.HomeApi
import vrsalex.matule.domain.model.home.HomeResult
import vrsalex.matule.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi) : HomeRepository {
    override suspend fun test(): HomeResult {
        val res = homeApi.getProfile()
        return when(res.code()){
            200 -> HomeResult.Success
            else -> HomeResult.Error
        }
    }
}