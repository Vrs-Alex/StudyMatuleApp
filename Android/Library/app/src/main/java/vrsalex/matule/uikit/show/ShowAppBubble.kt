package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.button.AppBubble
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.component.button.BubbleType
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppBubble() {

    Row(
        modifier = Modifier.padding(AppTheme.spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing8)
    ) {
        AppBubble(BubbleType.Size32, AppIconKey.LEFT) { }

        AppBubble(BubbleType.Size48, AppIconKey.FILTER) { }

        AppBubble(BubbleType.Size48, AppIconKey.MESSAGE) { }
    }
}