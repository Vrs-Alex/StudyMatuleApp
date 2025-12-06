package vrsalex.matule.uikit.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme

enum class BubbleSize(val size: Dp, val radius: Dp){
    Dp32(32.dp, 8.dp), Dp48(48.dp, 10.dp)
}

@Composable
fun Bubble(
    iconId: SystemIcon,
    size: BubbleSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconColor: Color = AppTheme.colors.description
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier.size(size.size)
            .clip(RoundedCornerShape(size.radius))
            .background(AppTheme.colors.inputBg)
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = ripple()
            ),
        contentAlignment = Alignment.Center
    ){
        SystemIcon(iconId, tint = iconColor)
    }
}