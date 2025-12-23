package vrsalex.matule.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vrsalex.matule.domain.usecase.auth.LogoutUseCase
import vrsalex.matule.domain.usecase.profile.GetProfileDataUseCase
import vrsalex.matule.domain.usecase.setting.SetShowNotificationUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val setShowNotificationUseCase: SetShowNotificationUseCase,
    getProfileDataUseCase: GetProfileDataUseCase
): ViewModel() {


    val state: StateFlow<ProfileContract.State> = getProfileDataUseCase()
        .map {
            ProfileContract.State(
                name = it.name,
                phone = it.phone,
                showNotification = it.isShowNotification
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ProfileContract.State()
        )


    fun onEvent(event: ProfileContract.Event){
        when(event){
            is ProfileContract.Event.OnShowNotification -> {
                viewModelScope.launch { setShowNotificationUseCase(event.isEnable) }
            }

            ProfileContract.Event.OnLogout -> {
                viewModelScope.launch { logoutUseCase() }
            }

        }
    }



}