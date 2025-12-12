package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.Bubble
import vrsalex.matule.uikit.component.button.BubbleSize
import vrsalex.matule.uikit.component.header.LargeHeader
import vrsalex.matule.uikit.component.header.SmallHeader
import vrsalex.matule.uikit.component.icon.SystemIcon

@Composable
fun ShowHeader() {

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

        SmallHeader("Загловок")

        SmallHeader(
            title = "Загловок 2",
            startContent = {
                Bubble(
                    iconId = SystemIcon.LEFT,
                    size = BubbleSize.Dp32,
                    onClick = {

                    }
                )
            }
        )

        SmallHeader(
            title = "Профиль",
            startContent = {
                Bubble(
                    iconId = SystemIcon.LEFT,
                    size = BubbleSize.Dp32,
                    onClick = {

                    }
                )
            },
            endContent = {
                SystemIcon(
                    icon = SystemIcon.DELETE,
                )
            }
        )


        LargeHeader(
            title = "Корзина",
            onBackPressed = {},
            actionContent = {
                SystemIcon(
                    icon = SystemIcon.DELETE,
                    onClick = {}
                )
            }
        )

    }

}