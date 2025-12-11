package vrsalex.matule.uikit.component.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun Chip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val color = if (isSelected) AppTheme.colors.accent else AppTheme.colors.inputBg
    val contentColor = if (isSelected) White else AppTheme.colors.description


    Surface(
        onClick = onClick,
        modifier = modifier.width(126.dp).height(48.dp),
        shape = RoundedCornerShape(10.dp),
        color = color,
        contentColor = contentColor,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = text, style = AppTheme.typography.textMedium, color = contentColor)
        }
    }

}