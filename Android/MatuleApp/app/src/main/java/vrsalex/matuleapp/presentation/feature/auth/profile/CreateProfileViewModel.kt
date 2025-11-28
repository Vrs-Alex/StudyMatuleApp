package vrsalex.matuleapp.presentation.feature.auth.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<CreateProfileUiState>(CreateProfileUiState())
    val uiState: StateFlow<CreateProfileUiState> get() = _uiState


    fun onEvent(event: CreateProfileEvent) {
        when (event) {
            is CreateProfileEvent.BirthdayChanged -> {
                _uiState.value = _uiState.value.copy(birthday = event.value)
            }
            is CreateProfileEvent.FirstNameChanged -> {
                _uiState.value = _uiState.value.copy(fistName = event.value)
            }
            is CreateProfileEvent.LastNameChanged -> {
                _uiState.value = _uiState.value.copy(lastName = event.value)
            }
            is CreateProfileEvent.PatronymicChanged -> {
                _uiState.value = _uiState.value.copy(patronymic = event.value)
            }
            is CreateProfileEvent.SexChanged -> {
                _uiState.value = _uiState.value.copy(sex = event.value)
            }
            is CreateProfileEvent.TelegramChanged -> {
                _uiState.value = _uiState.value.copy(telegram = event.value)
            }
        }
    }

    fun checkButtonEnabled() : Boolean{
        return uiState.value.fistName.isNotEmpty() && uiState.value.lastName.isNotEmpty() && uiState.value.patronymic.isNotEmpty() && uiState.value.telegram.isNotEmpty()
    }


    fun onNext(){

    }
}