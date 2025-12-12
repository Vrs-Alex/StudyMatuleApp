package vrsalex.matule.uikit.component.card

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun CardSmall(
    text: String,
    cost: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {

    val borderColor by animateColorAsState(
        if (enabled) AppTheme.colors.description else AppTheme.colors.inputIcon
    )
    val contentColor by animateColorAsState(
        if (enabled) Black else AppTheme.colors.inputIcon
    )

    val modifierClickable = if (enabled)
        Modifier.clip(RoundedCornerShape(10.dp)).clickable(
        interactionSource = null,
        indication = ripple(),
        onClick = onClick
    ) else Modifier

    Surface(
        modifier = modifier.fillMaxWidth().height(60.dp).then(modifierClickable),
        shape = RoundedCornerShape(10.dp),
        color = Transparent,
        contentColor = contentColor,
        border = BorderStroke(1.dp, borderColor)
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                style = AppTheme.typography.caption2Regular,
                color = contentColor
            )

            Text(
                modifier = Modifier.padding(start = 32.dp),
                text = cost,
                style = AppTheme.typography.caption2Regular,
                color = contentColor
            )
        }
    }

}
