package vrsalex.matule.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vrsalex.matule.data.remote.dto.project.AddProjectRequest
import vrsalex.matule.data.remote.dto.project.ProjectCategoryResponse
import vrsalex.matule.data.remote.dto.project.ProjectResponse
import vrsalex.matule.data.remote.dto.project.ProjectTypeResponse
import vrsalex.matule.domain.model.project.ProjectType

interface ProjectApi {

    @GET("project/get")
    suspend fun getProjects(): List<ProjectResponse>

    @POST("project/add")
    suspend fun addProject(@Body request: AddProjectRequest): Response<Unit>

    @GET("project/type/get")
    suspend fun getTypes(): List<ProjectTypeResponse>

    @GET("project/category/get")
    suspend fun getCategories(): List<ProjectCategoryResponse>

}