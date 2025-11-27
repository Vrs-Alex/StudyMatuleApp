package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.button.AppShopCart
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShopAppShopCart() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.spacing.spacing16)
    ) {
        AppShopCart(
            "500"
        )
    }

}