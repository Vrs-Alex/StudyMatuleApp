package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppSelectorField
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowShopSelectorFiled() {


    val value by remember { mutableStateOf<String?>(null) }

    val value2 by remember { mutableStateOf<String>("🧑‍ Гарвард Троцкий") }


    Column(
        modifier = Modifier.padding(AppTheme.spacing.spacing16),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.spacing16)
    ) {
        AppSelectorField(value, "Пол", {})

        AppSelectorField(value, "Пол", {}, label = "Пол")

        AppSelectorField(value2, "Пол", {}, label = "Пол")
    }
}