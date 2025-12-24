package vrsalex.matule.presentation.project.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import vrsalex.matule.domain.usecase.project.ObserveProjectUseCase
import vrsalex.matule.domain.usecase.project.SyncProjectUseCase
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    observeProjectUseCase: ObserveProjectUseCase,
    private val syncProjectUseCase: SyncProjectUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            syncProjectUseCase()
        }
    }

    val state: StateFlow<ProjectContract.State> = observeProjectUseCase()
        .map { list ->
            ProjectContract.State(projects = list, isLoading = false)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ProjectContract.State(isLoading = true)
        )



    fun onEvent(event: ProjectContract.Event){
        when(event) {
            ProjectContract.Event.OnAddProjectClicked -> {

            }
            ProjectContract.Event.OnProjectClicked -> {

            }
        }
    }
}