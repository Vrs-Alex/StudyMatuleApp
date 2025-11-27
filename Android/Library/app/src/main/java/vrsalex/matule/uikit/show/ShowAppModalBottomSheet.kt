package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppModalBottomSheet
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.AppButtonSize
import vrsalex.matule.uikit.component.button.AppButtonType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowAppModalBottomSheet() {


    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppButton(
            buttonSize = AppButtonSize.Large,
            buttonType = AppButtonType.Primary,
            onClick = { showBottomSheet = true }
        ) {
            Text("Открыть bottom sheet")
        }
    }


    AppModalBottomSheet(
        title = "Рубашка Воскресенье для машинного вязания",
        isVisible = showBottomSheet,
        sheetState = sheetState,
        onDismissRequest = {
            showBottomSheet = false
        }
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Здесь какой-то контент шторки...")
            Spacer(modifier = Modifier.height(150.dp))
        }
    }


}