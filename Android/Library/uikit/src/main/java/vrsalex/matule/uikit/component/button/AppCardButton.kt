package vrsalex.matule.uikit.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun AppCardButton(
    leftText: String,
    rightText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    AppButton(
        buttonSize = ButtonSize.BIG,
        buttonType = ButtonType.PRIMARY,
        onClick = onClick,
        content = {
            Row(
                modifier = modifier.padding(16.dp).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SystemIcon(
                        icon = SystemIcon.SHOPPING_CART,
                        tint = White
                    )
                    Text(text = leftText, style = AppTheme.typography.title3Semibold, color = White)
                }
                Text(text = rightText, style = AppTheme.typography.title3Semibold, color = White)
            }
        },
        modifier = modifier
    )

}