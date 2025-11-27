package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.controls.AppCheckbox
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.White

@Composable
fun AppSmallCard(
    title: String,
    cost: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onChangeCheckBox: ((Boolean) -> Unit)? = null,
    enable: Boolean = true,
    isChecked: Boolean? = null
) {

    Surface(
        modifier = modifier.alpha(if (enable) 1f else 0.5f),
        onClick = onClick,
        color = White,
        shape = RoundedCornerShape(if (isChecked != null) 0.dp else 10.dp),
        border = if (isChecked == null) BorderStroke(1.dp, Description) else null,
    ) {
        Column() {
            Row(
                modifier = Modifier.padding(AppTheme.spacing.spacing16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (onChangeCheckBox != null && isChecked != null) {
                        AppCheckbox(
                            isChecked = isChecked,
                            onCheckedChange = onChangeCheckBox
                        )
                    }
                    Text(
                        text = title,
                        style = AppTheme.typography.caption2Regular,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
                Text(text = cost, style = AppTheme.typography.textRegular)
            }
            if (isChecked != null) {
                HorizontalDivider(thickness = 1.dp, color = Description)
            }
        }

    }

}