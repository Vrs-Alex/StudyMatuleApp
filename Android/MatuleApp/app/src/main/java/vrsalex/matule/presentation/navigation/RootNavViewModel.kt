package vrsalex.matule.presentation.navigation

import androidx.activity.result.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vrsalex.matule.domain.repository.AuthEvent
import vrsalex.matule.domain.repository.AuthEventRepository
import vrsalex.matule.domain.usecase.navigation.GetStartDestinationUseCase
import vrsalex.matule.domain.usecase.profile.SyncProfileUseCase
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph
import javax.inject.Inject

@HiltViewModel
class RootNavViewModel @Inject constructor(
    private val getStartDestinationUseCase: GetStartDestinationUseCase,
    private val authEventRepository: AuthEventRepository,
    private val syncProfileUseCase: SyncProfileUseCase
) : ViewModel() {

    private val _startDestination = MutableStateFlow<Any?>(null)
    val startDestination = _startDestination.asStateFlow()

    val authEvent = authEventRepository.authEvents


    init {
        determineStartDestination()
    }

    private fun determineStartDestination() {
        viewModelScope.launch {
            val destination = getStartDestinationUseCase()
            if (destination == BottomTabsGraph) launch { syncProfileUseCase() }
            delay(450)
            _startDestination.value = destination
        }
    }

}