package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.input.AppSearchBar
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppSearchBar() {

    var value by remember { mutableStateOf("") }
    var isCancel by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
        .fillMaxWidth()
        .padding(AppTheme.spacing.spacing16)
    ) {

        AppSearchBar(
            value = value,
            showCancelButton = isCancel,
            onValueChange = {
                value = it
                if (value.isNotEmpty())
                    isCancel = true
                else isCancel = false
                            },
            placeholder = "Найти"
        )
    }

}