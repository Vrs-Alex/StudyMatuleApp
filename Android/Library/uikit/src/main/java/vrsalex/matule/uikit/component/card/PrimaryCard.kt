package vrsalex.matule.uikit.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black
import vrsalex.matule.uikit.theme.White

@Composable
fun PrimaryCard(
    title: String,
    description: String,
    cost: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
){


    CardBackground(onClick = onClick) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                style = AppTheme.typography.headLineMedium,
                color = Black,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = description,
                        style = AppTheme.typography.captionSemibold,
                        color = AppTheme.colors.caption,
                        maxLines = 1
                    )

                    Text(
                        text = cost,
                        style = AppTheme.typography.title3Semibold,
                        color = Black,
                        maxLines = 1
                    )
                }

                val buttonType = if (isSelected) ButtonType.SECONDARY else ButtonType.PRIMARY
                val buttonText = if (isSelected) "Убрать" else "Добавить"
                AppButton(
                    ButtonSize.SMALL,
                    buttonType,
                    onClick = onActionClick,
                    text = buttonText
                )
            }
        }
    }

}