package vrsalex.matuleapp.presentation.feature.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.AppButtonSize
import vrsalex.matule.uikit.component.button.AppButtonType
import vrsalex.matule.uikit.component.input.AppTextField
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matuleapp.R
import vrsalex.matuleapp.presentation.feature.auth.signin.SignInViewModel

@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = hiltViewModel(),
    onNextScreen: () -> Unit
) {
    val uiState = signInViewModel.signInUiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = AppTheme.spacing.spacing20),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing20)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16),
            ) {
                Image(
                    painter = painterResource(R.drawable.hello),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    "Добро пожаловать!",
                    style = AppTheme.typography.title1Bold
                )
            }
            Text(
                "Войдите, чтобы пользоваться функциями приложения",
                style = AppTheme.typography.textRegular
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTextField(
                value = uiState.value.email,
                onValueChange = { signInViewModel.onEvent(SignInEvent.EmailChanged(it)) },
                placeholder = "example@gmaail.com",
                label = "Вход по E-mail"
            )
            AppTextField(
                value = uiState.value.password,
                onValueChange = { signInViewModel.onEvent(SignInEvent.PasswordChanged(it)) },
                placeholder = "",
                label = "Пароль",
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation()
            )
            val buttonType = if (uiState.value.isButtonEnabled) AppButtonType.Primary
                else AppButtonType.Secondary
            AppButton(
                buttonSize = AppButtonSize.Large,
                buttonType = buttonType,
                onClick = {  if (uiState.value.isButtonEnabled) onNextScreen() }, // Заглушка signInViewModel.onEvent(SignInEvent.LoginClicked)
            ) {
                Text(
                    "Далее",
                    style = AppTheme.typography.title3Semibold
                )
            }
            Text(
                "Забыл пароль?",
                style = AppTheme.typography.textRegular,
                color = Accent,
            )
        }

        Column() {
            Box(modifier = Modifier.height(172.dp))
        }

    }
}