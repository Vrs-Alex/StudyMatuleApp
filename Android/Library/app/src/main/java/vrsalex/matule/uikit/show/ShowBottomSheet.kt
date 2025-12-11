package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.modal.AppModalBottomSheet
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowBottomSheet() {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        var visible1 by remember { mutableStateOf(false) }
        if (visible1) {
            AppModalBottomSheet(
                content = {},
                onDismissRequest = { visible1 = false },
            )
        }

        var visible2 by remember { mutableStateOf(false) }
        if (visible2) {
            AppModalBottomSheet(
                content = {
                    Spacer(Modifier.height(250.dp))
                },
                header = {
                    Text("Рубашка Воскресенье для машинного вязания", style = AppTheme.typography.title2Semibold, color = Black)
                },
                onDismissRequest = { visible2 = false },
            )
        }

        AppButton(
            buttonSize = ButtonSize.MEDIUM,
            buttonType = ButtonType.PRIMARY,
            onClick = { visible1 = true },
            content = { Text("Пустой bottom sheet", style = AppTheme.typography.textMedium) },
        )

        AppButton(
            buttonSize = ButtonSize.MEDIUM,
            buttonType = ButtonType.PRIMARY,
            onClick = { visible2 = true },
            content = { Text("Bottom sheet с контентом", style = AppTheme.typography.textMedium) },
        )



    }

}