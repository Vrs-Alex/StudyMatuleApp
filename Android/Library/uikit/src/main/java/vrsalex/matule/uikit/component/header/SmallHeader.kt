package vrsalex.matule.uikit.component.header


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Black
import vrsalex.matule.uikit.theme.White

@Composable
fun SmallHeader(
    title: String,
    modifier: Modifier = Modifier,
    startContent: @Composable () -> Unit = {},
    endContent: @Composable () -> Unit = {}
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .background(White)
        .padding(top = 2.dp, bottom = 18.dp),
        contentAlignment = Alignment.Center) {

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            startContent()
        }

        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = title,
            style = AppTheme.typography.title2Semibold,
            color = Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            endContent()
        }
    }
}