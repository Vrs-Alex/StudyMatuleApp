package vrsalex.matule.presentation.auth.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor() : ViewModel()
{
    private val _state = MutableStateFlow<CreateProfileContract.State>(CreateProfileContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<CreateProfileContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: CreateProfileContract.Event){
        when(event){
            is CreateProfileContract.Event.FirstNameChanged -> _state.update { it.copy(firstName = event.firstName) }
            is CreateProfileContract.Event.LastNameChanged -> _state.update { it.copy(lastName = event.lastName) }
            is CreateProfileContract.Event.PatronymicChanged -> _state.update { it.copy(patronymic = event.patronymic) }
            is CreateProfileContract.Event.BirthdayChanged -> _state.update { it.copy(birthday = event.birthday) }
            is CreateProfileContract.Event.GenderChanged -> _state.update { it.copy(gender = event.gender) }
            is CreateProfileContract.Event.PhoneChanged -> _state.update { it.copy(phone = event.phone) }
            CreateProfileContract.Event.CreateProfileClicked -> {
                _state.update { it.copy(isLoading = true) }
                createProfile()
            }
        }
    }

    private fun createProfile() = viewModelScope.launch{
        _effect.send(CreateProfileContract.Effect.OnCreateProfile)
    }


}