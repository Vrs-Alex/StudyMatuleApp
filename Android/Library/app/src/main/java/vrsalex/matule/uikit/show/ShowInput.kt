package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.input.EnterInputField
import vrsalex.matule.uikit.component.input.SingleInputField

@Composable
fun ShowInput() {


    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {


        var text by remember { mutableStateOf("Hello!") }
        EnterInputField(
            value = text,
            onValueChange = { text = it },
            placeholder = "Help: "
        )

        var text3 by remember { mutableStateOf("Hello!") }
        EnterInputField(
            value = text3,
            onValueChange = { text3 = it },
            placeholder = "Help: ",
            error = "Слишком большая длина строки"
        )

        var text4 by remember { mutableStateOf("") }
        EnterInputField(
            value = text4,
            onValueChange = { text4 = it },
            placeholder = "Help: ",
            label = "Password"
        )

        var text1 by remember { mutableStateOf("") }
        EnterInputField(
            value = text1,
            onValueChange = { text1 = it },
            placeholder = "Help: ",
            isPassword = true
        )


        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            var text11 by remember { mutableStateOf("") }
            var text12 by remember { mutableStateOf("") }
            SingleInputField(
                value = text11,
                onValueChange = { if (it.length <= 1) text11 = it }
            )

            SingleInputField(
                value = text12,
                onValueChange = { if (it.length <= 1) text12 = it }
            )
        }
    }

}