package vrsalex.matule.domain.repository

import kotlinx.coroutines.flow.Flow
import vrsalex.matule.domain.model.project.Project
import vrsalex.matule.domain.model.project.ProjectResult

interface ProjectRepository {

    fun observeProjects(): Flow<List<Project>>

    suspend fun addProject(project: Project): ProjectResult

    suspend fun updateProject(project: Project)

    suspend fun syncProjectsWithServer()

}