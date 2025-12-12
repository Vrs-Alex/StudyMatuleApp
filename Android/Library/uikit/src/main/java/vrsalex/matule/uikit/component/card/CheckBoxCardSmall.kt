package vrsalex.matule.uikit.component.card

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.control.CheckBox
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@Composable
fun CheckBoxCardSmall(
    text: String,
    cost: String,
    checked: Boolean,
    onChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

    val contentColor by animateColorAsState(
        if (checked) Black else AppTheme.colors.inputIcon
    )

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Transparent,
        contentColor = contentColor,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CheckBox(
                        checked = checked,
                        onCheckedChange = onChecked
                    )

                    Text(
                        modifier = Modifier,
                        text = text,
                        style = AppTheme.typography.caption2Regular,
                        color = contentColor
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 32.dp),
                    text = cost,
                    style = AppTheme.typography.caption2Regular,
                    color = contentColor
                )
            }
            Spacer(Modifier.height(8.dp))
            HorizontalDivider(thickness = 1.dp, color = AppTheme.colors.cardStroke)
        }
    }


}