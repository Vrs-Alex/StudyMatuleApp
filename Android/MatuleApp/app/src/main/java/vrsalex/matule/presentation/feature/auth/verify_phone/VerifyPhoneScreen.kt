package vrsalex.matule.presentation.feature.auth.verify_phone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.requestFocus
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.uikit.component.button.Bubble
import vrsalex.matule.uikit.component.button.BubbleSize
import vrsalex.matule.uikit.component.header.SmallHeader
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.component.input.SingleInputField
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun VerifyPhoneScreen(
    viewModel: VerifyPhoneViewModel = hiltViewModel(),
    onNavigateToCreateAppPassword: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    VerifyPhoneContent(
        state = state,
        onEvent = viewModel::onEvent,
        onNavigateBack
    )

}

@Composable
private fun VerifyPhoneContent(
    state: VerifyPhoneContract.State,
    onEvent: (VerifyPhoneContract.Event) -> Unit,
    onNavigateBack: () -> Unit
) {
    val focusRequesters = remember { List(state.codeLength) { FocusRequester() } }


    Box(Modifier.padding(20.dp).fillMaxSize().imePadding()){
        SmallHeader(
            title = "",
            startContent = {
                Bubble(
                    iconId = SystemIcon.LEFT,
                    size = BubbleSize.Dp32,
                    onClick = { onNavigateBack() }
                )
            }
        )

        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Введите код из Telegram",
                style = AppTheme.typography.title3Semibold,
                color = Black,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                repeat(state.codeLength) { index ->
                    val char = state.code.getOrNull(index)?.toString() ?: ""

                    SingleInputField(
                        modifier = Modifier.focusRequester(focusRequesters[index]),
                        value = char,
                        onValueChange = { newValue ->
                            val text = newValue.takeLast(1) // Берем только последний введенный символ

                            if (text.isNotBlank()) {
                                // 1. Формируем новую строку кода
                                val newCode = buildString {
                                    append(state.code)
                                    if (index < state.code.length) {
                                        // Если редактируем существующий символ
                                        replace(index, index + 1, text)
                                    } else {
                                        // Если добавляем новый
                                        append(text)
                                    }
                                }.take(state.codeLength)

                                onEvent(VerifyPhoneContract.Event.OnCodeChanged(newCode))

                                // 2. Переносим фокус на следующее поле
                                if (index < state.codeLength - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            } else {
                                // Если удалили символ (Backspace)
                                val newCode = if (index < state.code.length) {
                                    state.code.removeRange(index, index + 1)
                                } else state.code

                                onEvent(VerifyPhoneContract.Event.OnCodeChanged(newCode))

                                // Переносим фокус назад при удалении
                                if (index > 0) {
                                    focusRequesters[index - 1].requestFocus()
                                }
                            }
                        }
                    )
                }
            }
        }
    }


}