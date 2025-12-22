package vrsalex.matule.presentation.profile

object ProfileContract {

    data class State(
        val showNotification: Boolean = false
    )

    sealed interface Event {
        data object OnLogout: Event
        data object OnShowNotification: Event
    }

}