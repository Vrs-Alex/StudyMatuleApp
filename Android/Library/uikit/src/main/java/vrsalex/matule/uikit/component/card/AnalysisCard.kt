package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun AnalysisCard(
    title: String,
    description: String,
    state: CardState,
    modifier: Modifier = Modifier,
    onMoreClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {}
) {

    CardBackground() {
        Box() {
            SystemIcon(
                icon = SystemIcon.MORE,
                tint = Black,
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = onMoreClick
            )

            SystemIcon(
                icon = SystemIcon.DOWNLOAD,
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = onDownloadClick
            )

            Column(modifier = Modifier.padding(end = 52.dp)) {
                Text(
                    text = title,
                    style = AppTheme.typography.headLineMedium,
                    color = Black
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = description,
                    style = AppTheme.typography.captionRegular,
                    color = AppTheme.colors.caption
                )
                Spacer(Modifier.height(6.dp))
                state.StateContent()
            }
        }
    }
}