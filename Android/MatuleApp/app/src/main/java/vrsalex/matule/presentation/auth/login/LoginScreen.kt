package vrsalex.matule.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.R
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.input.EnterInputField
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLogin: () -> Unit = {},
    onRegister: () -> Unit = {}) {

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect){
                is LoginContract.Effect.OnLogin -> onLogin()
                is LoginContract.Effect.OnRegister -> onRegister()
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginContent(state, viewModel::onEvent)
}

@Composable
private fun LoginContent(
    state: LoginContract.State,
    onEvent: (LoginContract.Event) -> Unit
) {

    Column(
        Modifier.padding(20.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.hand),
                    contentDescription = null
                )
                Text(
                    text = "Добро пожаловать!",
                    style = AppTheme.typography.title1Heavy
                )
            }
            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                style = AppTheme.typography.textRegular
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            EnterInputField(
                value = state.email,
                onValueChange = { onEvent(LoginContract.Event.EmailChanged(it)) },
                placeholder = "example@mail.com",
                label = "Вход по E-mail",
                isAlphaBorder = true
            )
            EnterInputField(
                value = state.password,
                onValueChange = { onEvent(LoginContract.Event.PasswordChanged(it)) },
                placeholder = "",
                label = "Пароль",
                isAlphaBorder = true,
                isPassword = true
            )
            AppButton(
                buttonSize = ButtonSize.BIG,
                buttonType = if (state.isEnabledButton) ButtonType.PRIMARY else ButtonType.INACTIVE,
                onClick = { onEvent(LoginContract.Event.LoginClicked) },
                enabled = state.isEnabledButton,
                text = "Далее"
            )
            Text(
                text = "Забыл пароль?",
                modifier = Modifier.clickable(
                    interactionSource = null,
                    indication = ripple(),
                    onClick = {}
                ),
                style = AppTheme.typography.textRegular,
                color = AppTheme.colors.accent,
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(172.dp))
    }

}