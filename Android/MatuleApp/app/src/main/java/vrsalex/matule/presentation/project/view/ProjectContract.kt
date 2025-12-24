package vrsalex.matule.presentation.project.view

import vrsalex.matule.domain.model.project.Project

object ProjectContract {

    data class State(
        val projects: List<Project> = emptyList(),
        val isLoading: Boolean = false
    )

    sealed interface Event {
        data object OnAddProjectClicked : Event
        data object OnProjectClicked : Event
    }

}