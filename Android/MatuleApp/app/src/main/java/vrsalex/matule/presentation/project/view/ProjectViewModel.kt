package vrsalex.matule.presentation.project.view

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import vrsalex.matule.domain.model.project.ProjectResult
import vrsalex.matule.domain.usecase.project.ObserveProjectUseCase
import vrsalex.matule.domain.usecase.project.SyncProjectUseCase
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    observeProjectUseCase: ObserveProjectUseCase,
    private val syncProjectUseCase: SyncProjectUseCase,
    @param:ApplicationContext private val context: Context
): ViewModel() {

    init {
        viewModelScope.launch {
            val result = syncProjectUseCase()
            when(result){
                ProjectResult.Success -> {}
                ProjectResult.SyncError -> {
                    Toast.makeText(context, "Ошибка синхронизации", Toast.LENGTH_SHORT).show()
                }
                is ProjectResult.DatabaseError -> {}
                is ProjectResult.NetworkError -> {}
                is ProjectResult.UnknownError -> {}
            }
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