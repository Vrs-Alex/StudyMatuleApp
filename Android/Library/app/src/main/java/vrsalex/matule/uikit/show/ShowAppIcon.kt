package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppIcon
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppIcon() {

    FlowRow (
        modifier = Modifier.padding(AppTheme.spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing8),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing8)
    ) {
        AppIcon(AppIconKey.LEFT)
        AppIcon(AppIconKey.RIGHT)
        AppIcon(AppIconKey.DOWN)
        AppIcon(AppIconKey.SEARCH)
        AppIcon(AppIconKey.PLUS)
        AppIcon(AppIconKey.MINUS)
        AppIcon(AppIconKey.MESSAGE)
        AppIcon(AppIconKey.FILTER)
        AppIcon(AppIconKey.DOWNLOAD)
        AppIcon(AppIconKey.MAP)
        AppIcon(AppIconKey.MORE)
        AppIcon(AppIconKey.CLOSE)
        AppIcon(AppIconKey.DISMISS)
        AppIcon(AppIconKey.DELETE)
        AppIcon(AppIconKey.SHOP_CART)
        AppIcon(AppIconKey.CHECK)
        AppIcon(AppIconKey.FILE_TEXT)
        AppIcon(AppIconKey.SEND)
        AppIcon(AppIconKey.MIC)
        AppIcon(AppIconKey.PAPERCLIP)
    }
}