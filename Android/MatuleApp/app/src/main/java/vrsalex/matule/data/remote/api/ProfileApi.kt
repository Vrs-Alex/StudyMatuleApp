package vrsalex.matule.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import vrsalex.matule.data.remote.dto.profile.ProfileDataResponse

interface ProfileApi {

    @GET("profile/get")
    suspend fun getProfile(): ProfileDataResponse

}