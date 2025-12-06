package vrsalex.matule.uikit.component.control

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun Toggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    colors: SwitchColors = SwitchDefaults.colors()
) {

    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedThumbColor = White,
            checkedTrackColor = AppTheme.colors.accent,
            uncheckedThumbColor = White,
            uncheckedTrackColor = AppTheme.colors.inputStroke,
            uncheckedBorderColor = Transparent,
            checkedBorderColor = Transparent
        ),
        thumbContent = {
            Box(
                modifier = Modifier.size(24.dp).clip(CircleShape),
            )
        }
    )

}