package vrsalex.matule.presentation.feature.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.R
import vrsalex.matule.presentation.feature.auth.AuthRoute
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.input.EnterInputField
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToCreateProfile: () -> Unit,
    onNavigateToCreateAppPassword: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                LoginContract.Effect.NavigateToCreateAppPassword -> onNavigateToCreateAppPassword()
                LoginContract.Effect.NavigateToCreateProfile -> onNavigateToCreateProfile()
            }
        }
    }

    LoginContent(
        state,
        viewModel::onEvent
    )
}



@Composable
private fun LoginContent(
    state: LoginContract.LoginState,
    onEvent: (LoginContract.LoginEvent) -> Unit
    ) {

    Column(modifier = Modifier
        .padding(horizontal = 20.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Image(
                    painter = painterResource(R.drawable.hand),
                    contentDescription = "Hand",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "Добро пожаловать!",
                    style = AppTheme.typography.title1Heavy,
                    color = Black
                )
            }
            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                style = AppTheme.typography.textRegular,
                color = Black
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            EnterInputField(
                value = state.email,
                onValueChange = { onEvent(LoginContract.LoginEvent.EmailChanged(it)) },
                placeholder = "example@mail.com",
                label = "Вход по E-mail"
            )
            EnterInputField(
                value = state.password,
                onValueChange = { onEvent(LoginContract.LoginEvent.PasswordChanged(it)) },
                placeholder = "",
                label = "Пароль",
                isPassword = true
            )
            AppButton(
                buttonSize = ButtonSize.BIG,
                buttonType = if (state.isButtonEnabled) ButtonType.PRIMARY else ButtonType.INACTIVE,
                onClick = { onEvent(LoginContract.LoginEvent.OnLoginClick(state.email, state.password)) },
                text = "Далее"
            )
            Text(
                text = "Забыл пароль?",
                style = AppTheme.typography.textRegular,
                color = AppTheme.colors.accent
            )
        }

        Column() {
            Spacer(Modifier.height(172.dp))
        }
    }

}