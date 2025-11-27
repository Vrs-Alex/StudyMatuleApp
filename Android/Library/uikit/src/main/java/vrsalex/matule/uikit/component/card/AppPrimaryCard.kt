package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun AppPrimaryCard(
    title: String,
    description: String,
    cost: String,
    actionButton: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = White,
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.spacing.spacing16),
            verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16)
        ) {
            Text(
                text = title,
                style = AppTheme.typography.headLineMedium,
                maxLines = 2
            )
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start,
                    ) {
                    Text(text = description, style = AppTheme.typography.captionSemibold)
                    Text(text = cost, style = AppTheme.typography.title3Semibold)
                }
                actionButton()
            }
        }
    }

}