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
import vrsalex.matule.data.repository.AuthSessionRepositoryImpl
import vrsalex.matule.domain.model.auth.RegisterResult
import vrsalex.matule.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val authSessionRepositoryImpl: AuthSessionRepositoryImpl,
    private val authRepository: AuthRepository
) : ViewModel()
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
            CreateProfileContract.Event.CreateProfileClicked -> { createProfile() }
        }
    }

    private fun createProfile() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        authSessionRepositoryImpl.data.update {
            it?.copy(firstName = _state.value.firstName, lastName = _state.value.lastName,
                patronymic = _state.value.patronymic, birthday = _state.value.birthday,
                gender = _state.value.gender!!, phoneNum = _state.value.phone)
        }
        val res = authRepository.register(authSessionRepositoryImpl.data.value!!)
        when(res){
            RegisterResult.Success -> {
                // Send sms
                _effect.send(CreateProfileContract.Effect.OnCreateProfile)
            }
            RegisterResult.UserAlreadyExists -> {

            }
            is RegisterResult.Error -> {

            }
        }
        _state.update { it.copy(isLoading = false) }
    }


}