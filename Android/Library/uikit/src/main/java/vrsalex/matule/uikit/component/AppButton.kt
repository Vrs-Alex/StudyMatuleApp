package vrsalex.matule.uikit.component

import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.theme.Accent
import vrsalex.matule.uikit.theme.AccentInactive
import vrsalex.matule.uikit.theme.White

enum class AppButtonSize {
    Small, Medium, Large
}

enum class AppButtonType {
    Primary, Secondary, Inactive
}


@Composable
fun AppButton(
    buttonSize: AppButtonSize,
    buttonType: AppButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {

    val heightModifier = when (buttonSize) {
        AppButtonSize.Small -> Modifier.height(40.dp).width(96.dp)
        AppButtonSize.Medium -> Modifier.height(48.dp)
        AppButtonSize.Large -> Modifier.height(56.dp)
    }

    val borderBtn = when (buttonType) {
        AppButtonType.Primary -> BorderStroke(1.dp, Accent)
        AppButtonType.Secondary -> BorderStroke(1.dp, AccentInactive)
        AppButtonType.Inactive -> BorderStroke(1.dp, Accent)
    }

    val finalModifier = modifier
        .then(heightModifier)
        .fillMaxWidth()

    val colors = getAppButtonColors(buttonType)

    Button(
        onClick = onClick,
        modifier = finalModifier,
        colors = colors,
        border = borderBtn,
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        content()
    }

}

@Composable
private fun getAppButtonColors(buttonType: AppButtonType): ButtonColors {
    return when (buttonType) {
        AppButtonType.Primary -> ButtonDefaults.buttonColors(
            containerColor = Accent,
            contentColor = White
        )
        AppButtonType.Secondary -> ButtonDefaults.buttonColors(
            containerColor = AccentInactive,
            contentColor = White
        )
        AppButtonType.Inactive -> ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = Accent
        )
    }
}