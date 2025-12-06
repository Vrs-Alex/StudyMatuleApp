package vrsalex.matule.uikit.component.control

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.Bubble
import vrsalex.matule.uikit.component.button.BubbleSize
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun Counter(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val colorMinus = if (value == 0) AppTheme.colors.inputIcon else AppTheme.colors.caption

    Row(
        modifier = modifier
            .height(32.dp)
            .width(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(AppTheme.colors.inputBg)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Bubble(
                SystemIcon.MINUS,
                BubbleSize.Dp32,
                onClick = { onValueChange(value - 1) },
                iconColor = colorMinus
            )

            VerticalDivider(modifier = Modifier.height(16.dp), thickness = 1.dp, color = AppTheme.colors.inputStroke)

            Bubble(
                SystemIcon.PLUS,
                BubbleSize.Dp32,
                onClick = { onValueChange(value + 1) },
            )
        }
    }

}