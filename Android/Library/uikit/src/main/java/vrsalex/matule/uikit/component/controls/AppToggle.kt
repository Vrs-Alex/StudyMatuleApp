package vrsalex.matule.uikit.component.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.InputStroke
import vrsalex.matule.uikit.theme.White

@Composable
fun AppToggle(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Switch(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = {
            Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(White)){}
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = White,
            checkedTrackColor = Accent,
            uncheckedThumbColor = White,
            uncheckedTrackColor = InputStroke,
            uncheckedBorderColor = Transparent
        )
    )
}