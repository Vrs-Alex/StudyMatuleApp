package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.button.AppChip
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppChip() {

    var state by remember { mutableStateOf(false) }
    Row(modifier = Modifier.padding(AppTheme.spacing.spacing16)) {
        AppChip("Популярный", state, onClick = { state = !state })
    }
}