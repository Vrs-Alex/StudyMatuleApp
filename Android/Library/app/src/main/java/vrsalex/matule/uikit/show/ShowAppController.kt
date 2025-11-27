package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.controls.AppCheckbox
import vrsalex.matule.uikit.component.controls.AppCounter
import vrsalex.matule.uikit.component.controls.AppTimePicker
import vrsalex.matule.uikit.component.controls.AppToggle
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppController() {

    Row(
       modifier = Modifier.padding(AppTheme.spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16),
    ) {
        var isChecked by remember { mutableStateOf(true) }
        AppToggle(
            isChecked = isChecked,
            onCheckedChange = { isChecked = it }
        )

        AppCounter(
            count = 10,
            onPlusClick = {},
            onMinusClick = {}
        )

        var isSelected by remember { mutableStateOf(true) }
        AppTimePicker(
            time = "12:00",
            onClick = { isSelected = !isSelected },
            isSelected = isSelected
        )

        var isChecked2 by remember { mutableStateOf(true) }
        AppCheckbox(
            isChecked = isChecked2,
            onCheckedChange = { isChecked2 = !isChecked2 }
        )
    }
}