package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.AppButtonSize
import vrsalex.matule.uikit.component.button.AppButtonType
import vrsalex.matule.uikit.component.card.AnalysisStatus
import vrsalex.matule.uikit.component.card.AppAnalysisCard
import vrsalex.matule.uikit.component.card.AppPrimaryCard
import vrsalex.matule.uikit.component.card.AppSmallCard
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppCard() {


    Column(
        modifier = Modifier.padding(AppTheme.spacing.spacing16),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16)
    ) {

        var isSelected by remember { mutableStateOf(false) }
        AppPrimaryCard(
            title = "Рубашка Воскресенье для машинного вязания",
            description = "Мужская одежда",
            cost = "300 ₽",
            actionButton = {

                val text = if (isSelected) "Убрать" else "Добавить"
                val buttonType = if (isSelected) AppButtonType.Inactive else AppButtonType.Primary
                AppButton(
                    buttonSize = AppButtonSize.Small,
                    buttonType = buttonType,
                    onClick = { isSelected = !isSelected }
                ) {
                    Text(text = text, style = AppTheme.typography.captionSemibold)
                }
            }
        )

        var isChecked by remember { mutableStateOf(true) }
        AppSmallCard(
            title = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            isChecked = isChecked,
            onClick = {},
            onChangeCheckBox = { isChecked = it }
        )

        var isChecked2 by remember { mutableStateOf(true) }
        AppSmallCard(
            title = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            isChecked = isChecked2,
            onClick = {},
            onChangeCheckBox = { isChecked2 = it },
            enable = false
        )

        AppSmallCard(
            title = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            onClick = {},
        )
        AppSmallCard(
            title = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            enable = false,
            onClick = {},
        )

        AppAnalysisCard(
            text =  "Рубашка Воскресенье для машинного вязания",
            date = "12 февраля",
            status = AnalysisStatus.BUY
        )

    }

}