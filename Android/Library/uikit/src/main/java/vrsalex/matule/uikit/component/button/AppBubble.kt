package vrsalex.matule.uikit.component.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppIcon
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.InputBackground

enum class BubbleType(val size: Dp) {
    Size32(32.dp), Size48(48.dp)
}


@Composable
fun AppBubble(
    type: BubbleType,
    iconKey: AppIconKey,
    onClick: () -> Unit
) {
    Surface(
        onClick = { onClick() },
        color = InputBackground,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(type.size)
    ) {
        Box(contentAlignment = Alignment.Center){
            AppIcon(iconKey, tint = Description)
        }
    }
}