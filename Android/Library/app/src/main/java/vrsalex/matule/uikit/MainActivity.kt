package vrsalex.matule.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.show.ShowBottomSheet
import vrsalex.matule.uikit.show.ShowBubble
import vrsalex.matule.uikit.show.ShowButton
import vrsalex.matule.uikit.show.ShowCard
import vrsalex.matule.uikit.show.ShowControllers
import vrsalex.matule.uikit.show.ShowInput
import vrsalex.matule.uikit.show.ShowSearch
import vrsalex.matule.uikit.show.ShowSelect
import vrsalex.matule.uikit.show.ShowSystemIcon
import vrsalex.matule.uikit.show.ShowTabBar
import vrsalex.matule.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Column(
                    modifier = Modifier.fillMaxSize().statusBarsPadding().padding(horizontal = 16.dp, vertical = 32.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    ShowSystemIcon()

                    ShowControllers()

                    ShowBubble()

                    ShowInput()

                    ShowSearch()

                    ShowButton()

                    ShowBottomSheet()

                    ShowSelect()

                    ShowTabBar()

                    ShowCard()
                }
            }
        }
    }
}
