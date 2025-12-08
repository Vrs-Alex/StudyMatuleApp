package vrsalex.matule.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun SingleInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    val focusRequest = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    val borderColor by animateColorAsState(
        when {
            isFocused -> AppTheme.colors.accent.copy(alpha = 0.5f)
            else -> AppTheme.colors.inputIcon
        }
    )

    Box(
        modifier = modifier.size(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(AppTheme.colors.inputBg)
            .border(1.dp, borderColor, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxSize().focusRequester(focusRequest).onFocusChanged{ isFocused = it.hasFocus },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = AppTheme.typography.title2Regular.copy(color = AppTheme.colors.caption, textAlign = TextAlign.Center),
            singleLine = true,
            maxLines = 1,
            decorationBox = {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    it()
                }
            }
        )
    }
}