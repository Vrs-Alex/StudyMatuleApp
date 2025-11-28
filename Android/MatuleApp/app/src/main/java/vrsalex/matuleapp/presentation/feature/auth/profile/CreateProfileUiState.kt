package vrsalex.matuleapp.presentation.feature.auth.profile

data class CreateProfileUiState(
    val isLoading: Boolean = false,
    val fistName: String = "",
    val lastName: String = "",
    val patronymic: String = "",
    val birthday: String = "",
    val sex: String = "",
    val telegram: String = ""
){
    val isButtonEnabled: Boolean
        get() = fistName.isNotEmpty() && lastName.isNotEmpty() &&
                patronymic.isNotEmpty() && telegram.isNotEmpty() && birthday.isNotEmpty()

}