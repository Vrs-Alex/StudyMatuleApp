package vrsalex.matule.presentation.profile

object ProfileContract {

    data class State(
        val name: String = "",
        val phone: String = "",
        val showNotification: Boolean = false
    )

    sealed interface Event {
        data object OnLogout: Event
        data class OnShowNotification(val isEnable: Boolean): Event
    }

}