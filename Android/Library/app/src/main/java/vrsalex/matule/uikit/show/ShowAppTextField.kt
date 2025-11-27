package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppTextField
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppTextField() {

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("Иван") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    var text5 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(AppTheme.spacing.spacing16)
    ) {
        val spacing = AppTheme.spacing

        AppTextField(
            value = text1,
            onValueChange = { text1 = it },
            placeholder = "Введите имя",
            modifier = Modifier.padding(vertical = spacing.spacing12)
        )


        AppTextField(
            value = text2,
            onValueChange = { text2 = it },
            placeholder = "Введите имя",
            modifier = Modifier.padding(vertical = spacing.spacing12)
        )

        AppTextField(
            value = text3,
            onValueChange = { text3 = it },
            placeholder = "Введите имя",
            label = "Имя",
            modifier = Modifier.padding(vertical = spacing.spacing12)
        )

        AppTextField(
            value = text4,
            onValueChange = { text4 = it },
            placeholder = "Введите имя",
            label = "Имя",
            errorMessage = "Введите ваше имя",
            modifier = Modifier.padding(vertical = spacing.spacing12)
        )

        AppTextField(
            value = text5,
            onValueChange = { text5 = it },
            placeholder = "Введите имя",
            label = "Имя",
            modifier = Modifier.padding(vertical = spacing.spacing12)
        )
    }
}