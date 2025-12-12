package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black


@Composable
fun OrderCard(
    title: String,
    cost: String,
    date: String,
    state: CardState,
    onLooksClick: () -> Unit,
    isOpened: Boolean,
    modifier: Modifier = Modifier,
) {

    CardBackground(
        modifier = modifier
    ) {
        Column(){

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = title,
                    style = AppTheme.typography.title3Semibold,
                    color = Black,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = cost,
                    style = AppTheme.typography.headLineRegular,
                    color = Black
                )
            }
            Spacer(Modifier.height(8.dp))

            Row() {
                Text(
                    text = date,
                    style = AppTheme.typography.captionRegular,
                    color = AppTheme.colors.caption
                )

                Text(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    text = "•",
                    style = AppTheme.typography.captionRegular,
                    color = AppTheme.colors.caption
                )

                state.StateContent()
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.clip(RoundedCornerShape(4.dp))
                    .clickable(
                    onClick = onLooksClick,
                    indication = ripple(),
                    interactionSource = null
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SystemIcon(
                    icon = SystemIcon.FILE_TEXT,
                    tint = AppTheme.colors.caption
                )
                Text(
                    text = "Посмотреть",
                    style = AppTheme.typography.headLineRegular,
                    color = AppTheme.colors.caption
                )
            }

        }
    }

}