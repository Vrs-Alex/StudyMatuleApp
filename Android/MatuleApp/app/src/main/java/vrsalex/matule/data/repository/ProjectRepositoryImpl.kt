package vrsalex.matule.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import vrsalex.matule.data.local.database.dao.ProjectDao
import vrsalex.matule.data.local.mapper.toDomain
import vrsalex.matule.data.local.mapper.toEntity
import vrsalex.matule.data.remote.api.ProjectApi
import vrsalex.matule.data.remote.dto.project.AddProjectRequest
import vrsalex.matule.data.remote.mapper.toAddRequest
import vrsalex.matule.data.remote.mapper.toDomain
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.model.project.ProjectResult
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

    override suspend fun addProject(project: Project): ProjectResult {
        return try {
            val localId = try {
                projectDao.insertProject(project.toEntity())
            } catch (e: Exception) {
                return ProjectResult.DatabaseError("Ошибка сохранения проекта")
            }

            try {
                projectApi.addProject(project.toAddRequest().copy(id = localId))
            } catch (e: Exception) {
                return ProjectResult.NetworkError("Данные сохранены локально, но не отправлены на сервер")
            }

            ProjectResult.Success
        } catch (e: Exception) {
            ProjectResult.UnknownError(e.message ?: "Ошибка")
        }
    }

    override suspend fun updateProject(project: Project) {

    }

    override suspend fun syncProjectsWithServer(): ProjectResult {
        return try {
            val types = projectApi.getTypes()
            projectDao.insertAllTypes(types.map { it.toDomain().toEntity() })

            val categories = projectApi.getCategories()
            projectDao.insertAllCategories(categories.map { it.toDomain().toEntity() })

            val projects = projectApi.getProjects()
            projectDao.insertAll(projects.map { it.toDomain().toEntity() })
            ProjectResult.Success
        } catch (e: Exception) {
            ProjectResult.SyncError
        }
    }


}