package vrsalex.matule.uikit.component

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Caption
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.InputStroke

@Composable
fun AppSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    onCancel: () -> Unit = {},
    showCancelButton: Boolean = false
) {

    var isFocused by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(InputBackground)
                .border(1.dp, InputStroke, RoundedCornerShape(10.dp))
                .padding(horizontal = AppTheme.spacing.spacing16),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AppIcon(AppIconKey.SEARCH, tint = Description)

            Spacer(Modifier.width(AppTheme.spacing.spacing8))

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = AppTheme.typography.headLineRegular,
                modifier = Modifier
                    .weight(1f)
                    .onFocusChanged { focusState -> isFocused = focusState.isFocused },

                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = Caption,
                                style = AppTheme.typography.headLineRegular
                            )
                        }
                        innerTextField()
                    }
                }
            )

            if (value.isNotEmpty()) {
                AppIcon(AppIconKey.CLOSE, tint = Description, onClick = { onValueChange("") })
            }
        }

        if (showCancelButton && isFocused) {
            Spacer(Modifier.width(AppTheme.spacing.spacing16))
            Text(
                text = "Отменить",
                color = Accent,
                style = AppTheme.typography.captionRegular,
                modifier = Modifier.clickable(
                    onClick = onCancel,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(bounded = true)
                )
            )
        }
    }
}