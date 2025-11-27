package vrsalex.matule.uikit.show

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppHeader
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppHeader() {


    Column(
        modifier = Modifier.background(Color.Gray).padding(vertical = AppTheme.spacing.spacing16),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16)
    ) {
        AppHeader(
            title = "Корзина",
            onNavigationClick = {  },
            onActionClick = {},
            actionIcon = AppIconKey.DELETE
        )

        AppHeader(
            title = "Корзина",
            twoStory = true,
            onNavigationClick = {  },
            onActionClick = {},
            actionIcon = AppIconKey.DELETE
        )
    }

}