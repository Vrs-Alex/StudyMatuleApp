package vrsalex.matule.uikit.component.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun SearchInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isAlwaysCancel: Boolean = false,
    additionContent: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
                .background(AppTheme.colors.inputBg)
                .border(1.dp, AppTheme.colors.inputStroke, RoundedCornerShape(10.dp))
                .padding(14.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SystemIcon(
                icon = SystemIcon.SEARCH,
                tint = AppTheme.colors.description
            )

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f),
                textStyle = AppTheme.typography.headLineRegular.copy(color = Black),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = AppTheme.typography.headLineRegular, color = AppTheme.colors.caption)
                        }
                        innerTextField()
                    }
                }
            )
            if (isAlwaysCancel || value.isNotEmpty()){
                SystemIcon(
                    icon = SystemIcon.CLOSE,
                    tint = AppTheme.colors.description,
                    onClick = { onValueChange("") }
                )
            }

        }
        additionContent()
    }
}