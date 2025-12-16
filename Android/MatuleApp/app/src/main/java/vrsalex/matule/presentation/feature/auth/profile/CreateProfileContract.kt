package vrsalex.matule.presentation.feature.auth.profile

object CreateProfileContract {

    data class State(
        val email: String = "",
        val firstName: String = "",
        val lastName: String = "",
        val patronymic: String = "",
        val birthDate: String = "",
        val gender: String? = null,
        val phoneNumber: String = "",
    ){
        val isButtonEnabled: Boolean
            get() = firstName.isNotBlank() &&
                    lastName.isNotBlank() &&
                    patronymic.isNotBlank() &&
                    birthDate.isNotBlank() &&
                    !gender.isNullOrBlank() &&
                    phoneNumber.isNotBlank()
    }


    sealed interface Event {
        data class FirstNameChanged(val firstName: String) : Event
        data class LastNameChanged(val lastName: String) : Event
        data class PatronymicChanged(val patronymic: String) : Event
        data class BirthDateChanged(val birthDate: String) : Event
        data class GenderChanged(val gender: String?) : Event
        data class PhoneNumberChanged(val phoneNumber: String) : Event
        data object OnClick : Event
    }

    sealed interface Effect {
        data object NavigateToVerifyPhone : Effect
    }


}