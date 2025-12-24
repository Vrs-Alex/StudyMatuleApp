package vrsalex.matule.domain.usecase.project

import vrsalex.matule.domain.repository.ProjectRepository
import javax.inject.Inject

class SyncProjectUseCase @Inject constructor(
    private val projectRepository: ProjectRepository
) {

    suspend operator fun invoke() = projectRepository.syncProjectsWithServer()

}