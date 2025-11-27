package vrsalex.matule.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.AppBubble
import vrsalex.matule.uikit.component.button.BubbleType
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun AppHeader(
    title: String? = null,
    twoStory: Boolean = false,
    onNavigationClick: (() -> Unit)? = null,
    actionIcon: AppIconKey? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {

    Surface(
        color = White
    ) {
        if (twoStory) {
            Column(
                modifier = modifier.height(84.dp).fillMaxWidth().padding(horizontal = AppTheme.spacing.spacing16),
                verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing24)
            ) {
                if (onNavigationClick != null) AppBubble(BubbleType.Size32, AppIconKey.LEFT) { onNavigationClick() }
                else Spacer(Modifier.height(BubbleType.Size32.size))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(modifier = Modifier.padding(end = 16.dp).weight(1f)) {
                        Text(
                            text = title ?: "",
                            style = AppTheme.typography.title1Semibold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    if (actionIcon != null) AppIcon(actionIcon, onClick = onActionClick)
                }
            }
        }
        else {
            Row(
                modifier = Modifier.height(48.dp).fillMaxWidth().padding(horizontal = AppTheme.spacing.spacing16),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (onNavigationClick != null) AppBubble(BubbleType.Size32, AppIconKey.LEFT) { onNavigationClick() }
                    else Spacer(Modifier.width(BubbleType.Size32.size))
                Box(modifier = Modifier.padding(horizontal = 16.dp).weight(1f),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = title ?: "",
                        style = AppTheme.typography.title2Semibold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (actionIcon != null) AppIcon(actionIcon, onClick = onActionClick)
                    else Spacer(Modifier.width(20.dp))
            }
        }
    }
}

