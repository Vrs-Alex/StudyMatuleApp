package vrsalex.matule.uikit.component.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.component.button.AppBubble
import vrsalex.matule.uikit.component.button.BubbleType
import vrsalex.matule.uikit.theme.InputBackground
import vrsalex.matule.uikit.theme.InputStroke

@Composable
fun AppCounter(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        color = InputBackground,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AppBubble(
                type = BubbleType.Size32,
                iconKey = AppIconKey.MINUS,
                onClick = onMinusClick
            )

            Spacer(Modifier.height(16.dp).width(1.dp).background(color = InputStroke))

            AppBubble(
                type = BubbleType.Size32,
                iconKey = AppIconKey.PLUS,
                onClick = onPlusClick
            )
        }
    }
}