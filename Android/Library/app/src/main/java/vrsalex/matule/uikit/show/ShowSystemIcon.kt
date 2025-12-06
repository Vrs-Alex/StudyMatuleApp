package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.icon.SystemIcon

@Composable
fun ShowSystemIcon() {

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SystemIcon(SystemIcon.LEFT)
        SystemIcon(SystemIcon.RIGHT)
        SystemIcon(SystemIcon.DOWN)
        SystemIcon(SystemIcon.SEARCH)
        SystemIcon(SystemIcon.PLUS)
        SystemIcon(SystemIcon.MINUS)
        SystemIcon(SystemIcon.MESSAGE)
        SystemIcon(SystemIcon.FILTER)
        SystemIcon(SystemIcon.DOWNLOAD)
        SystemIcon(SystemIcon.MAP)
        SystemIcon(SystemIcon.MORE)
        SystemIcon(SystemIcon.CLOSE)
        SystemIcon(SystemIcon.DISMISS)
        SystemIcon(SystemIcon.DELETE)
        SystemIcon(SystemIcon.SHOPPING_CART)
        SystemIcon(SystemIcon.CHECK)
        SystemIcon(SystemIcon.FILE_TEXT)
        SystemIcon(SystemIcon.SEND)
        SystemIcon(SystemIcon.MIC)
        SystemIcon(SystemIcon.PAPERCLIP)
    }

}