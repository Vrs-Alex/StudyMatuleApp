package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppIcon
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black
import vrsalex.matule.uikit.theme.Caption
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.Error
import vrsalex.matule.uikit.theme.Success

enum class AnalysisStatus(val text: String, val color: Color ) {
    BUY("Куплено", Success),
    ERROR("Ошибка", Error)
}

@Composable
fun AppAnalysisCard(
    text: String,
    date: String,
    status: AnalysisStatus,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onMoreClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        onClick = onClick,
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(142.dp).padding(AppTheme.spacing.spacing16),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(end = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = text,
                    style = AppTheme.typography.headLineMedium,
                    maxLines = 2
                )


                Text(
                    text = date,
                    style = AppTheme.typography.captionRegular,
                    color = Caption
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = status.text,
                    style = AppTheme.typography.captionRegular,
                    color = status.color
                )
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
               AppIcon(
                   AppIconKey.MORE,
                   tint = Black,
                   onClick = onMoreClick
                   )

                AppIcon(
                    AppIconKey.DOWNLOAD,
                    tint = Description,
                    onClick = onDownloadClick
                )
            }
        }
    }
}