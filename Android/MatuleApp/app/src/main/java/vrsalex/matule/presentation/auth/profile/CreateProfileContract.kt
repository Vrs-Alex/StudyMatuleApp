package vrsalex.matule.presentation.auth.profile

object CreateProfileContract {

    data class State(
        val firstName: String = "",
        val lastName: String = "",
        val patronymic: String = "",
        val birthday: String = "",
        val gender: String? = null,
        val phone: String = "",
        val isLoading: Boolean = false
    ) {
        val isEnabledButton: Boolean
            get() = listOf(firstName, lastName, patronymic, birthday, phone).all { it.isNotEmpty() }
                        && gender != null && !isLoading
    }

    sealed interface Event {
        data class FirstNameChanged(val firstName: String) : Event
        data class LastNameChanged(val lastName: String) : Event
        data class PatronymicChanged(val patronymic: String) : Event
        data class BirthdayChanged(val birthday: String) : Event
        data class GenderChanged(val gender: String?) : Event
        data class PhoneChanged(val phone: String) : Event
        object CreateProfileClicked : Event
    }

    sealed interface Effect {
        data object OnCreateProfile: Effect
    }

}