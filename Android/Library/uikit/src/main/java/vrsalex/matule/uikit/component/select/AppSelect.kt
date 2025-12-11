package vrsalex.matule.uikit.component.select

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.component.modal.AppModalBottomSheet
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSelect(
    items: List<String>,
    onItemSelected: (String?) -> Unit,
    selectedItem: String?,
    placeholder: String,
    modifier: Modifier = Modifier,
    label: String? = null
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet){
        AppModalBottomSheet(
            state = sheetState,
            onDismissRequest = { showBottomSheet = false },
            content = {
                Column(modifier = modifier) {
                    items.forEach { item ->
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .clickable(
                                    interactionSource = null,
                                    indication = ripple(),
                                    onClick = {
                                        scope.launch {
                                            onItemSelected(item)
                                            sheetState.hide()
                                        }.invokeOnCompletion {
                                            showBottomSheet = false
                                        }
                                    }
                                )
                                .padding(16.dp)
                        ) {
                            Text(
                                text = item,
                                color = Black
                            )
                        }
                    }
                }
            },
            onCloseClick = {
                scope.launch {
                    onItemSelected(null)
                    sheetState.hide()
                }
            }
        )
    }


    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (label != null){
            Text(
                text = label,
                style = AppTheme.typography.captionRegular,
                color = AppTheme.colors.description
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(AppTheme.colors.inputBg)
                .border(1.dp, AppTheme.colors.inputStroke, RoundedCornerShape(10.dp))
                .clickable(
                    interactionSource = null,
                    indication = ripple(),
                    onClick = { showBottomSheet = true }
                )
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selectedItem != null) {
                Text(
                    text = selectedItem,
                    style = AppTheme.typography.headLineRegular,
                    color = Black,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Text(
                    text = placeholder,
                    style = AppTheme.typography.headLineRegular,
                    color = AppTheme.colors.caption,
                    modifier = Modifier.weight(1f)
                )
            }
            SystemIcon(
                icon = SystemIcon.DOWN,
                tint = AppTheme.colors.description
            )
        }
    }


}