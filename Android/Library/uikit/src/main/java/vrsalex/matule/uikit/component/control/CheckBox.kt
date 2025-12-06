package vrsalex.matule.uikit.component.control

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun CheckBox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    val backgroundColor = if (isChecked) AppTheme.colors.accent else AppTheme.colors.inputBg
    val border = if (isChecked) null else BorderStroke(1.dp, AppTheme.colors.inputStroke)
    Box(
        modifier = modifier.size(20.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .border(border ?: BorderStroke(0.dp, Transparent))
            .clickable(
                interactionSource = null,
                indication = ripple(),
                onClick = { onCheckedChange(!isChecked) }
            ),
        contentAlignment = Alignment.Center
    ){
        if (isChecked) {
            SystemIcon(
                icon = SystemIcon.CHECK,
                tint = White,
                modifier = Modifier.padding(4.dp)
            )
        }
    }

}