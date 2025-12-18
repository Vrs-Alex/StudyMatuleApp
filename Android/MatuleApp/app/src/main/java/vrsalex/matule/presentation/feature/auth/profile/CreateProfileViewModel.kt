package vrsalex.matule.presentation.feature.auth.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import vrsalex.matule.domain.repository.AuthSessionRepository
import javax.inject.Inject


@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val authSessionRepository: AuthSessionRepository
): ViewModel() {

    private val _state = MutableStateFlow(CreateProfileContract.State())
    val state = _state.asStateFlow()

    private val _effect = Channel<CreateProfileContract.Effect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: CreateProfileContract.Event) {
        when(event){
            is CreateProfileContract.Event.BirthDateChanged -> _state.value = state.value.copy(birthDate = event.birthDate)
            is CreateProfileContract.Event.FirstNameChanged -> _state.value = state.value.copy(firstName = event.firstName)
            is CreateProfileContract.Event.GenderChanged -> _state.value = state.value.copy(gender = event.gender)
            is CreateProfileContract.Event.LastNameChanged -> _state.value = state.value.copy(lastName = event.lastName)
            is CreateProfileContract.Event.PatronymicChanged -> _state.value = state.value.copy(patronymic = event.patronymic)
            is CreateProfileContract.Event.PhoneNumberChanged -> _state.value = state.value.copy(phoneNumber = event.phoneNumber)
            CreateProfileContract.Event.OnClick -> navigateToVerifyPhoneNumber()
        }
    }


    fun navigateToVerifyPhoneNumber() = viewModelScope.launch {
        if (state.value.isButtonEnabled) {
            authSessionRepository.saveProfileData(
                _state.value.firstName,
                _state.value.lastName,
                _state.value.patronymic,
                _state.value.birthDate,
                _state.value.gender!!,
                _state.value.phoneNumber
            )
            _effect.send(CreateProfileContract.Effect.NavigateToVerifyPhone)
        }
    }


}