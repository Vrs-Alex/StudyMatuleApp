package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.White

@Composable
fun CardBackground(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {

    val clickableModifier = if (onClick != null) Modifier.clickable(onClick = onClick, indication = ripple(), interactionSource = null)
        else Modifier

    Surface(
        modifier = modifier.fillMaxWidth().then(clickableModifier)
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0xFFE4EBF5).copy(alpha = 0.6f),
                shape = RoundedCornerShape(12.dp)
            ),
        border = BorderStroke(1.dp, Color(0xFFF4F4F4)),
        color = White,
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(Modifier.padding(16.dp))
        {
            content()
        }
    }

}