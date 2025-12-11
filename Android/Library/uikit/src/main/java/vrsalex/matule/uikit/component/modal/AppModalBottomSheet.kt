@file:OptIn(ExperimentalMaterial3Api::class)

package vrsalex.matule.uikit.component.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun AppModalBottomSheet(
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    state: SheetState = rememberModalBottomSheetState(),
    header: @Composable (() -> Unit)? = null,
    visibleHeader: Boolean = true,
    onCloseClick: (() -> Unit)? = null
) {

    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        sheetState = state,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        dragHandle = null,
        containerColor = White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            if (visibleHeader){
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        header?.invoke()
                    }
                    SystemIcon(
                        icon = SystemIcon.DISMISS,
                        tint = AppTheme.colors.description,
                        onClick = {
                            if (onCloseClick != null) onCloseClick()
                            else scope.launch { state.hide() }
                        }
                    )
                }
                Spacer(Modifier.height(24.dp))
            }
            content()
        }
    }

}