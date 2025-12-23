package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import vrsalex.matule.data.local.database.dao.ProjectDao
import vrsalex.matule.data.local.mapper.toDomain
import vrsalex.matule.data.local.mapper.toEntity
import vrsalex.matule.data.remote.api.ProjectApi
import vrsalex.matule.data.remote.dto.project.AddProjectRequest
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.repository.ProjectRepository
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor(
    private val projectDao: ProjectDao,
    private val projectApi: ProjectApi
): ProjectRepository {

    override fun observeProjects(): Flow<List<Project>> {
        return projectDao.getAllFullProjects()
            .map { list ->
                list.map { it.toDomain() }
            }
    }

    override suspend fun addProject(project: Project) {
        try {
            projectDao.insertProject(project.toEntity())

            projectApi.addProject(AddProjectRequest(
                name = project.name,
                startDate = project.startDate,
                endDate = project.endDate,
                url = project.url,
                typeId = project.type.id,
                categoryId = project.category.id
            ))
        } catch (e: Exception) {}
    }

    override suspend fun updateProject(project: Project) {

    }


}