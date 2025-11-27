package vrsalex.matule.uikit.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.White

enum class AppChipType {
    Active,
    Inactive
}

@Composable
fun AppChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val chipType = if (isSelected) AppChipType.Active else AppChipType.Inactive
    val (backgroundColor, textColor) = getChipColors(chipType)

    Surface(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true)
            ),
        shape = RoundedCornerShape(10.dp),
        color = backgroundColor,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = textColor,
                style = AppTheme.typography.textMedium
            )
        }
    }
}

@Composable
fun getChipColors(chipType: AppChipType): Pair<Color, Color> {
    return when (chipType) {
        AppChipType.Active -> Pair(Accent, White)
        AppChipType.Inactive -> Pair(InputBackground, Description)
    }
}