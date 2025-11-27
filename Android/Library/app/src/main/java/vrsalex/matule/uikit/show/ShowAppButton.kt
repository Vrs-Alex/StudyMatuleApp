package vrsalex.matule.uikit.show

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vrsalex.matule.uikit.component.AppButton
import vrsalex.matule.uikit.component.AppButtonSize
import vrsalex.matule.uikit.component.AppButtonType
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppButton() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        AppButton(
            buttonSize = AppButtonSize.Large,
            buttonType = AppButtonType.Primary,
            onClick = { println("Primary Clicked") }
        ) {
            Text("Подтвердить")
        }

        Spacer(Modifier.height(10.dp))

        AppButton(
            buttonSize = AppButtonSize.Large,
            buttonType = AppButtonType.Secondary,
            onClick = { println("Secondary Clicked") }
        ) {
            Text("Подтвердить", style = AppTheme.typography.textRegular)
        }

        Spacer(Modifier.height(10.dp))


        AppButton(
            buttonSize = AppButtonSize.Large,
            buttonType = AppButtonType.Inactive,
            onClick = { println("Outline Clicked") },
        ) {
            Text("Подтвердить", style = AppTheme.typography.textRegular)
        }

        Spacer(Modifier.height(10.dp))

        AppButton(
            buttonSize = AppButtonSize.Medium,
            buttonType = AppButtonType.Primary,
            onClick = { println("Primary Clicked") }
        ) {
            Text("Подтвердить")
        }

        Spacer(Modifier.height(10.dp))

        AppButton(
            buttonSize = AppButtonSize.Medium,
            buttonType = AppButtonType.Secondary,
            onClick = { println("Secondary Clicked") }
        ) {
            Text("Подтвердить", style = AppTheme.typography.textRegular)
        }

        Spacer(Modifier.height(10.dp))


        AppButton(
            buttonSize = AppButtonSize.Medium,
            buttonType = AppButtonType.Inactive,
            onClick = { println("Outline Clicked") },
        ) {
            Text("Подтвердить", style = AppTheme.typography.textRegular)
        }

        Spacer(Modifier.height(10.dp))


        Row() {
            AppButton(
                buttonSize = AppButtonSize.Small,
                buttonType = AppButtonType.Primary,
                onClick = { println("Small Add Clicked") }
            ) {
                Text("Добавить", style = AppTheme.typography.captionSemibold)
            }

            Spacer(Modifier.width(10.dp))

            AppButton(
                buttonSize = AppButtonSize.Small,
                buttonType = AppButtonType.Secondary,
                onClick = { /* ... */ },
            ) {
                Text("Убрать", style = AppTheme.typography.captionSemibold)
            }

            Spacer(Modifier.width(10.dp))


            AppButton(
                buttonSize = AppButtonSize.Small,
                buttonType = AppButtonType.Inactive,
                onClick = { /* ... */ },
            ) {
                Text("Убрать", style = AppTheme.typography.captionSemibold)
            }
        }
    }
}