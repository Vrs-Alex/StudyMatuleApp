package vrsalex.matule.uikit.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Caption
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.InputStroke

@Composable
fun AppSelectorField(
    value: String?,
    placeholder: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    content: (@Composable () -> Unit)? = null
) {

    Column(modifier = modifier.fillMaxWidth()) {

        if (label != null) {
            Text(
                text = label,
                style = AppTheme.typography.captionRegular,
                color = Description,
                modifier = Modifier.padding(bottom = AppTheme.spacing.spacing4)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(1.dp, InputStroke, RoundedCornerShape(10.dp))
                .background(InputBackground, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .clickable(
                    onClick = onClick, indication = ripple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                )
                .padding(horizontal = AppTheme.spacing.spacing16),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (content == null) {
                Text(
                    text = if (value == null || value.isEmpty()) placeholder else value,
                    style = AppTheme.typography.headLineRegular,
                    color = if (value != null) AppTheme.colors.text else Caption
                )
            }
            else content()

            AppIcon(key = AppIconKey.DOWN, tint = Description)

        }
    }

}