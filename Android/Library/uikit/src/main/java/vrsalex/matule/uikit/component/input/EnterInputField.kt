package vrsalex.matule.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.R
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun EnterInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    label: String? = null,
    error: String? = null,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val focusRequest = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }

    val backgroundTextField by animateColorAsState(
        if (error != null) AppTheme.colors.error.copy(alpha = 0.1f)
        else AppTheme.colors.inputBg
    )
    val borderColor by animateColorAsState(
        when {
            error != null -> AppTheme.colors.error
            isFocused -> AppTheme.colors.accent.copy(alpha = 0.5f)
            else -> AppTheme.colors.inputIcon
        }
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        if (label != null){
            Text(
                text = label,
                style = AppTheme.typography.captionRegular,
                color = AppTheme.colors.description
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                .background(backgroundTextField)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth().weight(1f)
                    .focusRequester(focusRequest)
                    .onFocusChanged {
                        isFocused = it.hasFocus
                    },
                singleLine = true,
                cursorBrush = SolidColor(AppTheme.colors.accent),
                textStyle = AppTheme.typography.textRegular.copy(color = Black),
                keyboardOptions = keyboardOptions,
                visualTransformation = if (!showPassword && isPassword) {
                    PasswordVisualTransformation(mask = '*')
                } else {
                    VisualTransformation.None
                },
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = AppTheme.typography.textRegular, color = AppTheme.colors.caption)
                        }
                        innerTextField()
                    }
                }
            )
            if (isPassword){
                val icon = if (showPassword) R.drawable.open_eyes
                    else R.drawable.close_eyes

                Icon(
                    painter = painterResource(id = icon),
                    tint = Black,
                    contentDescription = "Show password",
                    modifier = Modifier.padding(start = 4.dp).size(20.dp).clickable { showPassword = !showPassword }
                )
            }
        }
        if (error != null){
            Text(text = error, style = AppTheme.typography.captionRegular, color = AppTheme.colors.error)
        }
    }

}