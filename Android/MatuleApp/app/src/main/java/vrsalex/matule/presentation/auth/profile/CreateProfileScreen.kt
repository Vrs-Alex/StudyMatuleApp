package vrsalex.matule.presentation.auth.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.input.EnterInputField
import vrsalex.matule.uikit.component.select.AppSelect
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun CreateProfileScreen(
    viewModel: CreateProfileViewModel = hiltViewModel(),
    onCreateProfile: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect) {
                CreateProfileContract.Effect.OnCreateProfile -> onCreateProfile()
            }
        }
    }

    CreateProfileContent(state, viewModel::onEvent)
}


@Composable
private fun CreateProfileContent(
    state: CreateProfileContract.State,
    onEvent: (CreateProfileContract.Event) -> Unit
) {

    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Создание Профиля",
            style = AppTheme.typography.title1Heavy
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Без профиля вы не сможете создавать проекты.",
                style = AppTheme.typography.captionRegular,
                color = AppTheme.colors.caption
            )
            Text(
                text = "В профиле будут храниться результаты проектов и ваши описания.",
                style = AppTheme.typography.captionRegular,
                color = AppTheme.colors.caption
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            EnterInputField(
                value = state.firstName,
                onValueChange = { onEvent(CreateProfileContract.Event.FirstNameChanged(it)) },
                placeholder = "Имя",
                isAlphaBorder = true
            )
            EnterInputField(
                value = state.patronymic,
                onValueChange = { onEvent(CreateProfileContract.Event.PatronymicChanged(it)) },
                placeholder = "Отчество",
                isAlphaBorder = true
            )
            EnterInputField(
                value = state.lastName,
                onValueChange = { onEvent(CreateProfileContract.Event.LastNameChanged(it)) },
                placeholder = "Фамилия",
                isAlphaBorder = true
            )
            EnterInputField(
                value = state.birthday,
                onValueChange = { onEvent(CreateProfileContract.Event.BirthdayChanged(it)) },
                placeholder = "Дата рождения",
                isAlphaBorder = true
            )
            AppSelect(
                items = listOf("Мужской", "Женский"),
                onItemSelected = { onEvent(CreateProfileContract.Event.GenderChanged(it)) },
                selectedItem = state.gender,
                placeholder = "Пол"
            )
            EnterInputField(
                value = state.phone,
                onValueChange = { onEvent(CreateProfileContract.Event.PhoneChanged(it)) },
                placeholder = "Телефон",
                isAlphaBorder = true
            )
        }
        AppButton(
            buttonSize = ButtonSize.BIG,
            buttonType = if (state.isEnabledButton) ButtonType.PRIMARY else ButtonType.INACTIVE,
            onClick = { onEvent(CreateProfileContract.Event.CreateProfileClicked) },
            enabled = state.isEnabledButton,
            text = "Создать"
        )
    }

}