package vrsalex.matule.uikit.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.Error
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.InputStroke
import vrsalex.matule.uikit.theme.Placeholder

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    label: String? = null,
    errorMessage: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var isFocused by remember { mutableStateOf(false) }

    val colors = AppTheme.colors
    val typography = AppTheme.typography
    val spacing = AppTheme.spacing


    val containerShape = RoundedCornerShape(10.dp)
    val baseModifier = Modifier
        .height(50.dp)
        .background(
            color = if (errorMessage != null) Error.copy(alpha = 0.1f) else InputBackground,
            shape = containerShape
        )
        .border(
            width = 1.dp,
            color = when {
                (errorMessage != null) -> Error
                isFocused -> Accent.copy(0.5f)
                else -> InputStroke
            },
            shape = containerShape
        )

    Column(modifier = modifier.fillMaxWidth()) {
        if (label != null) {
            Text(
                text = label,
                style = typography.captionRegular,
                color = Description,
                modifier = Modifier.padding(bottom = spacing.spacing4)
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = baseModifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            textStyle = typography.textRegular.copy(
                color = colors.text
            ),
            enabled = enabled,
            singleLine = singleLine,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,   // Тип клавиатуры (Text, Number, Email и т.д.)
                imeAction = imeAction          // Действие на кнопке (Next, Done, Send и т.д.)
            ),
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxSize().padding(horizontal = spacing.spacing16),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = typography.textRegular.copy(color = Placeholder)
                        )
                    }
                    innerTextField()
                }
            }
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                style = typography.captionRegular,
                color = Error,
                modifier = Modifier.padding(top = spacing.spacing4)
            )
        }
    }
}