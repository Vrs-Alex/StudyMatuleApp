package vrsalex.matuleapp.presentation.feature.auth.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.uikit.component.AppSelectorField
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.AppButtonSize
import vrsalex.matule.uikit.component.button.AppButtonType
import vrsalex.matule.uikit.component.input.AppTextField
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Caption

@Composable
fun CreateProfileScreen(
    createProfileViewModel: CreateProfileViewModel = hiltViewModel(),
) {

    val uiState = createProfileViewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = AppTheme.spacing.spacing20),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            "Создание Профиля",
            style = AppTheme.typography.title1Bold,
        )
        Column() {
            Text(
                "Без профиля вы не сможете создавать проекты.",
                style = AppTheme.typography.captionRegular,
            )
            Spacer(modifier = Modifier.padding(AppTheme.spacing.spacing8))
            Text(
                "В профиле будут храниться результаты проектов и ваши описания.",
                style = AppTheme.typography.captionRegular,
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing24)
        ) {
            AppTextField(
                value = uiState.fistName,
                onValueChange = {
                    createProfileViewModel.onEvent(
                        CreateProfileEvent.FirstNameChanged(
                            it
                        )
                    )
                },
                placeholder = "Имя"
            )

            AppTextField(
                value = uiState.patronymic,
                onValueChange = {
                    createProfileViewModel.onEvent(
                        CreateProfileEvent.PatronymicChanged(
                            it
                        )
                    )
                },
                placeholder = "Отчество"
            )

            AppTextField(
                value = uiState.lastName,
                onValueChange = {
                    createProfileViewModel.onEvent(
                        CreateProfileEvent.LastNameChanged(
                            it
                        )
                    )
                },
                placeholder = "Фамилия"
            )

            AppTextField(
                value = uiState.birthday,
                onValueChange = {
                    createProfileViewModel.onEvent(
                        CreateProfileEvent.BirthdayChanged(
                            it
                        )
                    )
                },
                placeholder = "Дата рождения"
            )

            AppSelectorField(
                value = uiState.sex,
                placeholder = "Пол",
                onClick = {

                },
                content = {
                    Text(
                        "Пол",
                        style = AppTheme.typography.headLineRegular,
                        color = if (uiState.sex.isNotEmpty()) AppTheme.colors.text else Caption
                    )
                }
            )

            AppTextField(
                value = uiState.telegram,
                onValueChange = {
                    createProfileViewModel.onEvent(
                        CreateProfileEvent.TelegramChanged(
                            it
                        )
                    )
                },
                placeholder = "Телеграм"
            )
        }
        val buttonType = if (uiState.isButtonEnabled) AppButtonType.Primary else AppButtonType.Secondary
        AppButton(
            buttonType = buttonType,
            buttonSize = AppButtonSize.Large,
            onClick = { createProfileViewModel.onNext() },
        ) {
            Text(
                "Создать",
                style = AppTheme.typography.title3Semibold
            )
        }

    }

}