package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.AppIconKey
import vrsalex.matule.uikit.component.AppMenuButton
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowAppMenuButton() {

    Column(
        modifier = Modifier.padding(AppTheme.spacing.spacing16)
    ) { 
        AppMenuButton(
            title = "Результаты расчета",
            description = "1 новый результат",
            onClick = {  },
            iconKey = AppIconKey.FILE_TEXT
        )
    }
}