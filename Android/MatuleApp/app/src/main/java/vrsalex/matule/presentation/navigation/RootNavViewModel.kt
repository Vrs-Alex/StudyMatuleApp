package vrsalex.matule.presentation.navigation

import androidx.activity.result.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vrsalex.matule.domain.usecase.navigation.GetStartDestinationUseCase
import javax.inject.Inject

@HiltViewModel
class RootNavViewModel @Inject constructor(
    private val getStartDestinationUseCase: GetStartDestinationUseCase
) : ViewModel() {

    private val _startDestination = MutableStateFlow<Any?>(null)
    val startDestination = _startDestination.asStateFlow()

    init {
        determineStartDestination()
    }

    private fun determineStartDestination() {
        viewModelScope.launch {
            val destination = getStartDestinationUseCase()
            delay(450)
            _startDestination.value = destination
        }
    }

}