package vrsalex.matule.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Caption
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.Success

@Composable
fun AppMenuButton(
    title: String,
    description: String,
    onClick: () -> Unit,
    iconKey: AppIconKey,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxWidth().height(48.dp),
        onClick = onClick,
        color = AppTheme.colors.surface,
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16),
        ) {
            AppIcon(iconKey, modifier = Modifier.size(32.dp), tint = Success)
            Column(
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing4),
                modifier = Modifier.padding(vertical = AppTheme.spacing.spacing4)
            ) {
                Text(title, style = AppTheme.typography.title3Semibold)

                Text(description, style = AppTheme.typography.captionRegular, color = Caption)
            }
        }
    }

}