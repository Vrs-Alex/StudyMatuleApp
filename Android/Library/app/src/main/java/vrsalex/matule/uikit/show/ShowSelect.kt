package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.select.AppSelect

@Composable
fun ShowSelect() {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val textList = List(10) { "Item $it" }
        var selectedItem by remember { mutableStateOf<String?>(textList[0]) }
        AppSelect(
            items = textList,
            onItemSelected = { selectedItem = it },
            selectedItem = selectedItem,
            placeholder = "Элемент"
        )

        val textList2 = listOf<String>("Мужчина", "Женщина")
        var selectedItem2 by remember { mutableStateOf<String?>(null) }
        AppSelect(
            items = textList2,
            onItemSelected = { selectedItem2 = it },
            selectedItem = selectedItem2,
            placeholder = "Пол",
            label = "Выберите"
        )

    }
}