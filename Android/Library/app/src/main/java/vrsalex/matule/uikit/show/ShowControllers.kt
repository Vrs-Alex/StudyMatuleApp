package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.control.CheckBox
import vrsalex.matule.uikit.component.control.Counter
import vrsalex.matule.uikit.component.control.TimePicker
import vrsalex.matule.uikit.component.control.Toggle

@Composable
fun ShowControllers() {

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
        var checked by remember { mutableStateOf(false) }
        Toggle(
            checked = checked,
            onCheckedChange = { checked = !checked }
        )

        var num by remember { mutableStateOf(0) }
        Counter(num, onValueChange = { num = it })

        val time = "12:30"
        TimePicker(time, onClicked = {}, enabled = true)

        TimePicker(time, onClicked = {}, enabled = false)

        var isChecked by remember { mutableStateOf(false) }
        CheckBox(
            isChecked = isChecked,
            onCheckedChange = { isChecked = !isChecked }
        )
    }

}