package vrsalex.matule.uikit.component.control

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun TimePicker(
    time: String,
    onClicked: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (enabled) AppTheme.colors.accent else AppTheme.colors.inputBg
    val textColor = if (enabled) White else AppTheme.colors.description
    Box(
        modifier = modifier
            .height(40.dp)
            .width(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = null,
                indication = ripple(),
                onClick = onClicked
            ),
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = time,
            style = AppTheme.typography.headLineMedium,
            color = textColor
        )
    }

}