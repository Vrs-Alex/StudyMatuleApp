package vrsalex.matule.domain.repository

import kotlinx.coroutines.flow.Flow
import vrsalex.matule.domain.model.project.Project

interface ProjectRepository {

    fun observeProjects(): Flow<List<Project>>

    suspend fun addProject(project: Project)

    suspend fun updateProject(project: Project)

}