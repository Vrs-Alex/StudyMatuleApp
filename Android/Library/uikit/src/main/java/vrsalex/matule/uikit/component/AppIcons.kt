package vrsalex.matule.uikit.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.IconButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.R
import vrsalex.matule.uikit.theme.InputIcon

enum class AppIconKey(val resId: Int, val description: String) {
    LEFT(R.drawable.icon_chevron_left, "Стрелка влево"),
    RIGHT(R.drawable.icon_chevron_right, "Стрелка вправо"),
    DOWN(R.drawable.icon_chevron_down, "Стрелка вниз"),
    SEARCH(R.drawable.icon_search, "Поиск"),
    PLUS(R.drawable.icon_plus, "Плюс"),
    MINUS(R.drawable.icon_minus, "Минус"),
    MESSAGE(R.drawable.icon_message_circle, "Сообщение"),
    FILTER(R.drawable.icon_filter, "Фильтер"),
    DOWNLOAD(R.drawable.icon_download, "Загрузки"),
    MAP(R.drawable.icon_map, "Карта"),
    MORE(R.drawable.icon_more_horizontal, "Больше"),
    CLOSE(R.drawable.icon_close, "Закрыть"),
    DISMISS(R.drawable.icon_dismiss, "Отменить"),
    DELETE(R.drawable.icon_delete, "Удалить"),
    SHOP_CART(R.drawable.icon_shopping_cart, "Корзина"),
    CHECK(R.drawable.icon_check, "Проверка"),
    FILE_TEXT(R.drawable.icon_file_text, "Текстовый файл"),
    SEND(R.drawable.icon_send, "Отправить"),
    MIC(R.drawable.icon_mic, "Микрофон"),
    PAPERCLIP(R.drawable.icon_paperclip, "Закрепленное");
}


@Composable
fun AppIcon(
    key: AppIconKey,
    modifier: Modifier = Modifier,
    tint: Color = InputIcon,
    onClick: (() -> Unit)? = null
) {

    val modifierClick = if (onClick != null) {
        Modifier.clickable(
            onClick = onClick,
            interactionSource = remember { MutableInteractionSource() },
            indication = ripple(bounded = false)
        )
    } else Modifier

    Image(
        painter = painterResource(key.resId),
        contentDescription = key.description,
        modifier = modifier.then(modifierClick).size(20.dp),
        colorFilter = if (tint != Color.Unspecified) ColorFilter.tint(tint) else null
    )
}