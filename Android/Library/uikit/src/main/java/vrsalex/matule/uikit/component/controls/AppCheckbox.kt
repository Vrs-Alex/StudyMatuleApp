package vrsalex.matule.uikit.component.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppIcon
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.InputStroke
import vrsalex.matule.uikit.theme.White


@Composable
fun AppCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    val backgroundColor = if (isChecked) Accent else InputStroke
    val borderColor = if (isChecked) Accent else InputStroke
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable(
                onClick = { onCheckedChange(!isChecked) },
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true)
            )
            .background(backgroundColor)
            .border(2.dp, borderColor, RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            AppIcon(AppIconKey.CHECK, tint = White, modifier = Modifier.size(12.dp))
        }
    }
}