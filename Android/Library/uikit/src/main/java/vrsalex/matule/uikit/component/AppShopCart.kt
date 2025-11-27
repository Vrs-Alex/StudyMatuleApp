package vrsalex.matule.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White


@Composable
fun AppShopCart(
    price: String,
    modifier: Modifier = Modifier,
    text: String = "В корзину"
) {

    AppButton(
        buttonSize = AppButtonSize.Large,
        buttonType = AppButtonType.Primary,
        onClick = {},
        modifier = modifier
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16)
            ) {
                AppIcon(AppIconKey.SHOP_CART, tint = White)
                Text(
                    text = text,
                    style = AppTheme.typography.title3Semibold
                )
            }

            Text(
                text = "$price $",
                style = AppTheme.typography.title3Semibold
            )
        }
    }

}