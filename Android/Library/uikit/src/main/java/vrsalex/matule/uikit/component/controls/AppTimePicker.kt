package vrsalex.matule.uikit.component.controls

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Description
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.White

@Composable
fun AppTimePicker(
    time: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {

    Surface(
        onClick = onClick,
        modifier = modifier.width(70.dp).height(40.dp),
        color = if (isSelected) Accent else InputBackground,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = time,
                style = AppTheme.typography.headLineMedium,
                color = if (isSelected) White else Description
            )
        }
    }

}