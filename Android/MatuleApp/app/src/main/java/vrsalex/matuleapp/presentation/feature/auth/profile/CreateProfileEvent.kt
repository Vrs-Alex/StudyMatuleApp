package vrsalex.matuleapp.presentation.feature.auth.profile

import vrsalex.matuleapp.presentation.feature.auth.signin.SignInEvent

sealed interface CreateProfileEvent {

    data class FirstNameChanged(val value: String) : CreateProfileEvent

    data class LastNameChanged(val value: String) : CreateProfileEvent

    data class PatronymicChanged(val value: String) : CreateProfileEvent

    data class BirthdayChanged(val value: String) : CreateProfileEvent

    data class SexChanged(val value: String) : CreateProfileEvent

    data class TelegramChanged(val value: String) : CreateProfileEvent

}