package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.Bubble
import vrsalex.matule.uikit.component.button.BubbleSize
import vrsalex.matule.uikit.component.icon.SystemIcon

@Composable
fun ShowButton() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Bubble(
            size = BubbleSize.Dp32,
            iconId = SystemIcon.LEFT,
            onClick = {}
        )

        Bubble(
            size = BubbleSize.Dp48,
            iconId = SystemIcon.FILTER,
            onClick = {}
        )

        Bubble(
            size = BubbleSize.Dp48,
            iconId = SystemIcon.MESSAGE,
            onClick = {}
        )
    }

}