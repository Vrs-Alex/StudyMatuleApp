package vrsalex.matule.presentation.auth.account_password

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import vrsalex.matule.R
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.input.EnterInputField
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun AccountPasswordScreen(
    viewModel: AccountPasswordViewModel = hiltViewModel(),
    onNext: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect){
                AccountPasswordContract.Effect.OnNext -> onNext()
            }
        }
    }

    AccountPasswordContent(state, viewModel::onEvent)
}


@Composable
private fun AccountPasswordContent(
    state: AccountPasswordContract.State,
    onEvent: (AccountPasswordContract.Event) -> Unit
) {
    Column(
        Modifier.padding(20.dp).fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.hand),
                    contentDescription = null
                )
                Text(
                    text = "Создание пароля",
                    style = AppTheme.typography.title1Heavy
                )
            }
            Text(
                text = "Введите новый пароль",
                style = AppTheme.typography.textRegular
            )
        }
        Spacer(Modifier.weight(1f))
        Column() {
            EnterInputField(
                value = state.password,
                onValueChange = { onEvent(AccountPasswordContract.Event.PasswordChanged(it)) },
                placeholder = "",
                label = "Новый Пароль",
                isAlphaBorder = true,
                isPassword = true
            )
            Spacer(Modifier.height(12.dp))
            EnterInputField(
                value = state.confirmPassword,
                onValueChange = { onEvent(AccountPasswordContract.Event.ConfirmPasswordChanged(it)) },
                placeholder = "",
                label = "Повторите пароль",
                isAlphaBorder = true,
                isPassword = true
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                buttonSize = ButtonSize.BIG,
                buttonType = if (state.isEnabledButton) ButtonType.PRIMARY else ButtonType.INACTIVE,
                onClick = { onEvent(AccountPasswordContract.Event.OnNext) },
                enabled = state.isEnabledButton,
                text = "Далее"
            )
        }
        Spacer(Modifier.weight(3f))
    }

}