package vrsalex.matule.uikit.component.header


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.Bubble
import vrsalex.matule.uikit.component.button.BubbleSize
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black
import vrsalex.matule.uikit.theme.White


@Composable
fun LargeHeader(
    title: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    actionContent: @Composable () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth().background(White)) {
        Bubble(
            iconId = SystemIcon.LEFT,
            size = BubbleSize.Dp32,
            onClick = onBackPressed
        )
        Spacer(Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = title, style = AppTheme.typography.title1Heavy, color = Black)
            Spacer(Modifier.weight(1f))
            actionContent()
        }
    }
}