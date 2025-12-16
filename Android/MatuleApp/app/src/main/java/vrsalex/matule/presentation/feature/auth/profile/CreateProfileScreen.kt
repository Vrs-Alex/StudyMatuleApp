package vrsalex.matule.presentation.feature.auth.profile

import androidx.compose.foundation.background
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
import vrsalex.matule.uikit.theme.Black
import vrsalex.matule.uikit.theme.White

@Composable
fun CreateProfileScreen(
    viewmodel: CreateProfileViewModel = hiltViewModel(),
    onNavigateToVerifyPhoneNumber: () -> Unit
) {
    val state by viewmodel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewmodel.effect.collect { effect ->
            when (effect) {
                CreateProfileContract.Effect.NavigateToVerifyPhone -> onNavigateToVerifyPhoneNumber()
            }
        }
    }

    CreateProfileContent(
        state = state,
        onEvent = viewmodel::onEvent
    )
}


@Composable
private fun CreateProfileContent(
    state: CreateProfileContract.State,
    onEvent: (CreateProfileContract.Event) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Создание Профиля",
            style = AppTheme.typography.title1Heavy,
            color = Black
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

        Column(verticalArrangement = Arrangement.spacedBy(24.dp),) {
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
                value = state.birthDate,
                onValueChange = { onEvent(CreateProfileContract.Event.BirthDateChanged(it)) },
                placeholder = "Дата рождения",
                isAlphaBorder = true
            )
            AppSelect(
                items = listOf("Мужчина", "Жензина"),
                onItemSelected = { onEvent(CreateProfileContract.Event.GenderChanged(it)) },
                selectedItem = state.gender,
                placeholder = "Пол"
            )

            EnterInputField(
                value = state.phoneNumber,
                onValueChange = { onEvent(CreateProfileContract.Event.PhoneNumberChanged(it)) },
                placeholder = "Телефон",
                isAlphaBorder = true
            )
        }

        AppButton(
            buttonSize = ButtonSize.BIG,
            buttonType = if (state.isButtonEnabled) ButtonType.PRIMARY else ButtonType.INACTIVE,
            text = "Создать",
            onClick = { onEvent(CreateProfileContract.Event.OnClick) },
            enabled = state.isButtonEnabled
        )
    }






}