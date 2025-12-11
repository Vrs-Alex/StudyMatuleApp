package vrsalex.matule.uikit.show

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.search.SearchInputField
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ShowSearch() {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        var value1 by remember { mutableStateOf("") }
        SearchInputField(
            value = value1,
            onValueChange = { value1 = it },
            placeholder = "Search"
        )

        var value2 by remember { mutableStateOf("") }
        SearchInputField(
            value = value2,
            onValueChange = { value2 = it },
            placeholder = "Search 2: ",
            isAlwaysCancel = true
        )


        var value4 by remember { mutableStateOf("") }
        SearchInputField(
            value = value4,
            onValueChange = { value4 = it },
            placeholder = "Search 4: ",
            additionContent = {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                        .clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = { value4 = "" }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Отменить",
                        style = AppTheme.typography.captionRegular,
                        color = AppTheme.colors.accent
                    )
                }
            }
        )
    }

}