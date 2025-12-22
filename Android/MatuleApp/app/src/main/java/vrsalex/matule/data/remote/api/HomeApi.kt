package vrsalex.matule.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("profile/get")
    suspend fun getProfile(): Response<Unit>

}