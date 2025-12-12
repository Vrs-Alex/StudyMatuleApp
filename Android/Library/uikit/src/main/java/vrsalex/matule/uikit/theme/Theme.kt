package vrsalex.matule.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Immutable
data class AppColors(
    val accent: Color,
    val accentInactive: Color,
    val error: Color,
    val success: Color,
    val inputBg: Color,
    val inputStroke: Color,
    val inputIcon: Color,
    val placeholder: Color,
    val description: Color,
    val cardStroke: Color,
    val caption: Color
)


@Immutable
data class AppTypography(
    val title1Semibold: TextStyle,
    val title1Heavy: TextStyle,
    val title2Regular: TextStyle,
    val title2Semibold: TextStyle,
    val title2Heavy: TextStyle,
    val title3Regular: TextStyle,
    val title3Medium: TextStyle,
    val title3Semibold: TextStyle,
    val headLineRegular: TextStyle,
    val headLineMedium: TextStyle,
    val textRegular: TextStyle,
    val textMedium: TextStyle,
    val captionRegular: TextStyle,
    val captionSemibold: TextStyle,
    val caption2Regular: TextStyle,
    val caption2Bold: TextStyle
)

val AppColorsLocalComposition = staticCompositionLocalOf { 
    AppColors(
        Color.Unspecified, Color.Unspecified, Color.Unspecified,
        Color.Unspecified, Color.Unspecified, Color.Unspecified,
        Color.Unspecified, Color.Unspecified, Color.Unspecified, 
        Color.Unspecified, Color.Unspecified)
}

val AppTypographyLocalComposition = staticCompositionLocalOf { 
    AppTypography(
        title1Semibold = TextStyle.Default, title1Heavy = TextStyle.Default,
        title2Regular = TextStyle.Default, title2Semibold = TextStyle.Default, title2Heavy = TextStyle.Default,
        title3Regular = TextStyle.Default, title3Medium = TextStyle.Default, title3Semibold = TextStyle.Default,
        headLineRegular = TextStyle.Default, headLineMedium = TextStyle.Default,
        textRegular = TextStyle.Default, textMedium = TextStyle.Default,
        captionRegular = TextStyle.Default, captionSemibold = TextStyle.Default,
        caption2Regular = TextStyle.Default, caption2Bold = TextStyle.Default
    )
}


@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = AppColors(
        accent = Accent,
        accentInactive = AccentInactive,
        error = Error,
        success = Success,
        inputBg = InputBg,
        inputStroke = InputStroke,
        inputIcon = InputIcon,
        placeholder = Placeholder,
        description = Description,
        cardStroke = CardStroke,
        caption = Caption
    )

    val typography = AppTypography(
        title1Semibold = title1Base.copy(fontWeight = FontWeight.SemiBold),
        title1Heavy = title1Base.copy(fontWeight = FontWeight.Black),
        title2Regular = title2Base.copy(fontWeight = FontWeight.Normal),
        title2Semibold = title2Base.copy(fontWeight = FontWeight.SemiBold),
        title2Heavy = title2Base.copy(fontWeight = FontWeight.Black),
        title3Regular = title3Base.copy(fontWeight = FontWeight.Normal),
        title3Medium = title3Base.copy(fontWeight = FontWeight.Medium),
        title3Semibold = title3Base.copy(fontWeight = FontWeight.SemiBold),
        headLineRegular = headLineBase.copy(fontWeight = FontWeight.Normal),
        headLineMedium = headLineBase.copy(fontWeight = FontWeight.Medium),
        textRegular = textBase.copy(fontWeight = FontWeight.Normal),
        textMedium = textBase.copy(fontWeight = FontWeight.Medium),
        captionRegular = captionBase.copy(fontWeight = FontWeight.Normal),
        captionSemibold = captionBase.copy(fontWeight = FontWeight.SemiBold),
        caption2Regular = caption2Base.copy(fontWeight = FontWeight.Normal),
        caption2Bold = caption2Base.copy(fontWeight = FontWeight.Bold)
    )

    CompositionLocalProvider(
        AppColorsLocalComposition provides colors,
        AppTypographyLocalComposition provides typography,
        content = content
    )

}

object AppTheme {
    val colors: AppColors
        @Composable get() = AppColorsLocalComposition.current
    val typography: AppTypography
        @Composable get() = AppTypographyLocalComposition.current
}


private val title1Base = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.0033.em,
    color = White
)

private val title2Base = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.0038.em,
    color = White
)

private val title3Base = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.em,
    color = White
)

private val headLineBase = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    letterSpacing = -(0.0032).em,
    color = White
)

private val textBase = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.em,
    color = White
)

private val captionBase = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.em,
    color = White
)

private val caption2Base = TextStyle(
    fontFamily = sfProDisplayFont,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.em,
    color = White
)



