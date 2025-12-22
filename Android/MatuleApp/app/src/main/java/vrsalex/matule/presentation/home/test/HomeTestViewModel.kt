package vrsalex.matule.presentation.home.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import vrsalex.matule.domain.model.home.HomeResult
import vrsalex.matule.domain.repository.HomeRepository
import javax.inject.Inject

@HiltViewModel
class HomeTestViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {

    val text = MutableStateFlow("Текст")

    fun click() = viewModelScope.launch{
        val res = homeRepository.test()
        when(res){
            HomeResult.Success -> {
                text.value = "200"
            }
            HomeResult.Error -> {
                text.value = "401"
            }
        }
    }


}