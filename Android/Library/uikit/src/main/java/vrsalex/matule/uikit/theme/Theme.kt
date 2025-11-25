package vrsalex.matule.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Immutable
data class AppColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val onPrimary: Color,
    val text: Color
)

@Immutable
data class AppTypography(
    val title1Semibold: TextStyle,
    val title1Bold: TextStyle,

    val title2Regular: TextStyle,
    val title2Semibold: TextStyle,
    val title2Heavy: TextStyle,

    val title3Regular: TextStyle,
    val title3Semibold: TextStyle,
    val title3Medium: TextStyle,

    val headLineRegular: TextStyle,
    val headLineMedium: TextStyle,

    val captionRegular: TextStyle,
    val captionSemibold: TextStyle,

    val caption2Regular: TextStyle,
    val caption2Bold: TextStyle,

    val textRegular: TextStyle,
    val textMedium: TextStyle
)

@Immutable
data class AppSpacing(
    val spacing4: Dp,
    val spacing8: Dp,
    val spacing12: Dp,
    val spacing16: Dp,
    val spacing20: Dp,
    val spacing24: Dp,
    val spacing32: Dp,
    val spacing40: Dp,
    val spacing48: Dp,
    val spacing56: Dp,
    val spacing64: Dp
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        background = Color.Unspecified,
        surface = Color.Unspecified,
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        text = Color.Unspecified
    )
}

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        title1Semibold = TextStyle.Default,
        title1Bold = TextStyle.Default,
        title2Regular = TextStyle.Default,
        title2Semibold = TextStyle.Default,
        title2Heavy = TextStyle.Default,
        title3Regular = TextStyle.Default,
        title3Semibold = TextStyle.Default,
        title3Medium = TextStyle.Default,
        headLineRegular = TextStyle.Default,
        headLineMedium = TextStyle.Default,
        captionRegular = TextStyle.Default,
        captionSemibold = TextStyle.Default,
        caption2Regular = TextStyle.Default,
        caption2Bold = TextStyle.Default,
        textRegular = TextStyle.Default,
        textMedium = TextStyle.Default,
    )
}

val LocalAppSpacing = staticCompositionLocalOf {
    AppSpacing(
        spacing4 = Dp.Unspecified,
        spacing8 = Dp.Unspecified,
        spacing12 = Dp.Unspecified,
        spacing16 = Dp.Unspecified,
        spacing20 = Dp.Unspecified,
        spacing24 = Dp.Unspecified,
        spacing32 = Dp.Unspecified,
        spacing40 = Dp.Unspecified,
        spacing48 = Dp.Unspecified,
        spacing56 = Dp.Unspecified,
        spacing64 = Dp.Unspecified
    )
}


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = AppColors(
        background = Color.White,
        surface = Color.White,
        primary = Accent,
        onPrimary = Color.White,
        text = Black
    )
    val spacing = AppSpacing(4.dp, 8.dp, 12.dp, 16.dp, 20.dp, 24.dp,
        32.dp, 40.dp, 48.dp, 56.dp, 64.dp)

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography,
        LocalAppSpacing provides spacing,
        content = content
    )

}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current
    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
    val spacing: AppSpacing
        @Composable
        get() = LocalAppSpacing.current
}



private val typography = AppTypography(
    title1Semibold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.0033.em
    ),
    title1Bold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.0033.em
    ),
    title2Regular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.0038.em
    ),
    title2Semibold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.0038.em
    ),
    title2Heavy = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight(800),
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.0038.em
    ),
    title3Regular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em
    ),
    title3Semibold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em
    ),
    title3Medium = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em
    ),
    headLineRegular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = -(0.0032).em
    ),
    headLineMedium = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = -(0.0032).em
    ),
    textRegular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    textMedium = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    captionRegular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    captionSemibold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    caption2Regular = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.em
    ),
    caption2Bold = TextStyle(
        fontFamily = sfProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.em
    )
)