package vrsalex.matule.domain.usecase.project

import vrsalex.matule.domain.repository.ProjectRepository
import javax.inject.Inject


class ObserveProjectUseCase @Inject constructor(
    private val projectRepository: ProjectRepository
) {

    operator fun invoke() = projectRepository.observeProjects()

}