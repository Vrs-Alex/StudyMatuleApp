package vrsalex.matule.uikit.component.button

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White


enum class ButtonSize (val height: Dp) {
    SMALL(40.dp),
    MEDIUM(48.dp),
    BIG(56.dp)
}

enum class ButtonType {
    PRIMARY,
    INACTIVE,
    SECONDARY
}


@Composable
fun AppButton(
    buttonSize: ButtonSize,
    buttonType: ButtonType,
    onClick: () -> Unit,
    content: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String? = null
) {
    val btnWidthModifier = if (buttonSize == ButtonSize.BIG
        || buttonSize == ButtonSize.MEDIUM) Modifier.fillMaxWidth() else Modifier.width(96.dp)

    val buttonColor by animateColorAsState(
        when  (buttonType) {
            ButtonType.PRIMARY -> AppTheme.colors.accent
            ButtonType.INACTIVE -> AppTheme.colors.accentInactive
            ButtonType.SECONDARY -> Transparent
        }
    )



    val buttonContentColor by animateColorAsState(
        when  (buttonType) {
            ButtonType.PRIMARY, ButtonType.INACTIVE -> White
            ButtonType.SECONDARY -> AppTheme.colors.accent
    }
    )

    var buttonBorder =  when  (buttonType) {
        ButtonType.PRIMARY, ButtonType.INACTIVE -> null
        ButtonType.SECONDARY -> BorderStroke(1.dp, AppTheme.colors.accent)
    }
    if (!enabled) buttonBorder = null


    Button(
        onClick = { if (enabled) onClick() },
        modifier = modifier
            .height(buttonSize.height)
            .then(btnWidthModifier),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonContentColor
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(0.dp),
        border = buttonBorder,
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            content?.invoke()
            if (content == null && text != null)
                Text(
                    text = text,
                    style = AppTheme.typography.captionSemibold,
                    color = buttonContentColor
                )
        }
    }

}