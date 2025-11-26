package vrsalex.matule.uikit.component

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
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
    label: String? = null,
    errorMessage: String? = null
) {
    var isFocused by remember { mutableStateOf(false) }

    val colors = AppTheme.colors
    val typography = AppTheme.typography
    val spacing = AppTheme.spacing


    val containerShape = RoundedCornerShape(10.dp)
    val baseModifier = modifier
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

    Column(modifier = Modifier.fillMaxWidth()) {
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
            textStyle = typography.textRegular.copy(
                color = colors.text
            ),
            singleLine = true,
            modifier = baseModifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },

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