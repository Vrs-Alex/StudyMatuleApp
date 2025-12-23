package vrsalex.matule.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vrsalex.matule.data.remote.dto.project.AddProjectRequest
import vrsalex.matule.data.remote.dto.project.ProjectResponse

interface ProjectApi {

    @GET("project/get")
    suspend fun getProjects(): List<ProjectResponse>

    @POST("project/add")
    suspend fun addProject(@Body request: AddProjectRequest): Response<Unit>

}