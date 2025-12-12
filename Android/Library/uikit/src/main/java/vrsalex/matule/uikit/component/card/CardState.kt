package vrsalex.matule.uikit.component.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import vrsalex.matule.uikit.theme.AppTheme


sealed interface CardState {

    @Composable
    fun getColor(): Color

    @Composable
    fun StateContent()


    object Buy : CardState {
        @Composable
        override fun getColor(): Color = AppTheme.colors.success

        @Composable
        override fun StateContent() {
            Text(
                text = "Куплено",
                style = AppTheme.typography.captionRegular,
                color = getColor()
            )
        }
    }

    object Paid : CardState {
        @Composable
        override fun getColor(): Color = AppTheme.colors.success

        @Composable
        override fun StateContent() {
            Text(
                text = "Оплачено",
                style = AppTheme.typography.captionRegular,
                color = getColor()
            )
        }
    }

    object Cancel : CardState {
        @Composable
        override fun getColor(): Color = AppTheme.colors.error

        @Composable
        override fun StateContent() {
            Text(
                text = "Отмена",
                style = AppTheme.typography.captionRegular,
                color = getColor()
            )
        }
    }



}