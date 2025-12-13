package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.card.AnalysisCard
import vrsalex.matule.uikit.component.card.CardState
import vrsalex.matule.uikit.component.card.CardBackground
import vrsalex.matule.uikit.component.card.CardSmall
import vrsalex.matule.uikit.component.card.CheckBoxCardSmall
import vrsalex.matule.uikit.component.card.OrderCard
import vrsalex.matule.uikit.component.card.PrimaryCard

@Composable
fun ShowCard() {


    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        CardBackground() { }


        var isSelected by remember { mutableStateOf(false) }
        PrimaryCard(
            title = "Рубашка Воскресенье для машинного вязания",
            description = "Мужская одежда",
            cost = "300 ₽",
            isSelected = isSelected,
            onClick = { },
            onActionClick = { isSelected = !isSelected }
        )


        CardSmall(
            text = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            onClick = {}
        )

        CardSmall(
            text = "Рубашка Воскресенье для машинного вязания",
            cost = "300 ₽",
            onClick = {},
            enabled = false
        )

        var isChecked by remember { mutableStateOf(false) }
        CheckBoxCardSmall(
            text = "Рубашка Воскресенье для машинного вязания",
            cost = "500 ₽",
            checked = isChecked,
            onChecked = { isChecked = !isChecked },
        )

        var state by remember { mutableStateOf<CardState>(CardState.Buy) }
        AnalysisCard(
            title = "Рубашка Воскресенье для машинного вязания",
            description = "16 февраля",
            state = state,
            onMoreClick = { state = CardState.Cancel  },
        )


        var isOpened by remember { mutableStateOf(false) }
        OrderCard(
            title = "Заказ № 123456",
            cost = "2580 ₽",
            date = "26 апреля, 14:00",
            state = CardState.Paid,
            isOpened = isOpened,
            onLooksClick = { isOpened = !isOpened }
        )

    }
    
}