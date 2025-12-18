package vrsalex.matule.presentation.auth.verify_phone

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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

@Composable
fun VerifyPhoneScreen(
    viewModel: VerifyPhoneViewModel = hiltViewModel(),
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect){
                VerifyPhoneContract.Effect.OnNext -> onNext()
                VerifyPhoneContract.Effect.OnBack -> onBack()
            }
        }
    }

    VerifyPhoneContent(state, viewModel::onEvent)
}


@Composable
private fun VerifyPhoneContent(
    state: VerifyPhoneContract.State,
    onEvent: (VerifyPhoneContract.Event) -> Unit
) {
    val focusRequesters = remember { List(state.codeLength) { FocusRequester() } }
    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }

    Box(Modifier.fillMaxSize().padding(20.dp).imePadding()) {
        SmallHeader(
            modifier = Modifier.align(Alignment.TopCenter),
            title = "",
            startContent = {
                Bubble(
                    iconId = SystemIcon.LEFT,
                    size = BubbleSize.Dp32,
                    onClick = {
                        onEvent(VerifyPhoneContract.Event.BackClicked)
                    }
                )
            }
        )

        Column(Modifier.fillMaxWidth().align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Введите код из Telegram",
                style = AppTheme.typography.title3Semibold
            )
            Spacer(Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                repeat(state.codeLength) { index ->
                    val char = state.code.getOrNull(index)?.toString() ?: ""
                    SingleInputField(
                        value = char,
                        onValueChange = { newValue ->
                            val char = if (newValue.length > char.length) newValue.last().toString() else ""

                            // Формируем новый код
                            val newCode = if (char.isNotEmpty()) {
                                // Заменяем или добавляем символ
                                if (index < state.code.length) {
                                    state.code.replaceRange(index, index + 1, char)
                                } else {
                                    state.code + char
                                }
                            } else {
                                // Если newValue короче, значит это удаление
                                if (index < state.code.length) state.code.removeRange(index, index + 1) else state.code
                            }

                            // Отправляем событие
                            onEvent(VerifyPhoneContract.Event.CodeChanged(newCode))

                            // УПРАВЛЕНИЕ ФОКУСОМ
                            if (char.isNotEmpty()) {
                                // Если ввели символ — прыгаем вперед
                                if (index < state.codeLength - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            } else {
                                // Если удалили — прыгаем назад
                                if (index > 0) {
                                    focusRequesters[index - 1].requestFocus()
                                }
                            }
                        },
                        modifier = Modifier.focusRequester(focusRequesters[index])
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            AnimatedContent(
                targetState = state.isTimerActive,
                label = "TimerAnimation"
            ) { isTimerActive ->
                val text = if (isTimerActive) {
                    "Отправить код повторно можно будет через ${state.resendTime} секунд"
                } else {
                    "Отправить код повторно"
                }

                Text(
                    text = text,
                    style = AppTheme.typography.textRegular,
                    color = AppTheme.colors.caption,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 45.dp).clickable(enabled = !isTimerActive) {
                        onEvent(VerifyPhoneContract.Event.ResendCodeClicked)
                    }
                )
            }
        }
    }

}