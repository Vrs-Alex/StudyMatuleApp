package vrsalex.matule.uikit.component.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.R
import vrsalex.matule.uikit.theme.AppTheme


enum class SystemIcon(val id: Int, val descroption: String = ""){
    LEFT(R.drawable.icon_chevron_left, "Left"),
    RIGHT(R.drawable.icon_chevron_right, "Right"),
    DOWN(R.drawable.icon_chevron_down, "Down"),
    SEARCH(R.drawable.icon_search, "Search"),
    PLUS(R.drawable.icon_plus, "Plus"),
    MINUS(R.drawable.icon_minus, "Minus"),
    MESSAGE(R.drawable.icon_message_circle, "Message"),
    FILTER(R.drawable.icon_filter, "Filter"),
    DOWNLOAD(R.drawable.icon_download, "Download"),
    MAP(R.drawable.icon_map, "Map"),
    MORE(R.drawable.icon_more_horizontal, "More"),
    CLOSE(R.drawable.icon_close, "Close"),
    DISMISS(R.drawable.icon_dismiss, "Dismiss"),
    DELETE(R.drawable.icon_delete, "Delete"),
    SHOPPING_CART(R.drawable.icon_shopping_cart, "Shopping Cart"),
    CHECK(R.drawable.icon_check, "Check"),
    FILE_TEXT(R.drawable.icon_file_text, "File Text"),
    SEND(R.drawable.icon_send, "Send"),
    MIC(R.drawable.icon_mic, "Mic"),
    PAPERCLIP(R.drawable.icon_paperclip, "Paperclip")
}


@Composable
fun SystemIcon(
    icon: SystemIcon,
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.inputIcon,
    onClick: (() -> Unit)? = null
) {

    val clickableModifier = if (onClick != null) Modifier.clickable(
        interactionSource = null,
        indication = ripple(true, 3.dp),
        onClick = onClick ) else Modifier

    Icon(
        painter = painterResource(icon.id),
        contentDescription = icon.descroption,
        modifier = modifier.size(20.dp).then(clickableModifier),
        tint = tint,
    )

}