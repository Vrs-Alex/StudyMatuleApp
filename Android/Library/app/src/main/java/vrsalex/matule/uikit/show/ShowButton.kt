package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.AppCardButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.button.Chip

@Composable
fun ShowButton() {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        AppButton(
            ButtonSize.BIG,
            ButtonType.PRIMARY,
            onClick = {},
            content = { Text("Press") }
        )

        AppButton(
            ButtonSize.BIG,
            ButtonType.INACTIVE,
            onClick = {},
            content = { Text("Button") }
        )

        AppButton(
            ButtonSize.BIG,
            ButtonType.SECONDARY,
            onClick = {},
            content = { Text("Button") }
        )

        AppButton(
            ButtonSize.MEDIUM,
            ButtonType.PRIMARY,
            onClick = {},
            content = { Text("Press") }
        )

        AppButton(
            ButtonSize.MEDIUM,
            ButtonType.INACTIVE,
            onClick = {},
            content = { Text("Button") }
        )

        AppButton(
            ButtonSize.MEDIUM,
            ButtonType.SECONDARY,
            onClick = {},
            content = { Text("Button") }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AppButton(
                ButtonSize.SMALL,
                ButtonType.PRIMARY,
                onClick = {},
                content = { Text("Press") }
            )

            AppButton(
                ButtonSize.SMALL,
                ButtonType.INACTIVE,
                onClick = {},
                content = { Text("Button") }
            )

            AppButton(
                ButtonSize.SMALL,
                ButtonType.SECONDARY,
                onClick = {},
                content = { Text("Button") }
            )
        }

        AppCardButton(
            leftText = "В корзину",
            rightText = "500 $",
            onClick = {},
        )

        var state by remember { mutableStateOf(false) }
        Chip(
            "Популярные",
            isSelected = state,
            onClick = { state = !state }
        )

    }

}