package vrsalex.matule.uikit.component.tabbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun BottomTabItem(
    bottomTab: BottomTab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val color by animateColorAsState(
        if (selected) AppTheme.colors.accent else AppTheme.colors.inputIcon
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    ) {
        Icon(
            modifier = Modifier.weight(1f),
            painter = painterResource(bottomTab.iconId),
            contentDescription = bottomTab.title,
            tint = color
        )
        Text(
            text = bottomTab.title,
            style = AppTheme.typography.caption2Regular,
            color = color
        )
    }

}