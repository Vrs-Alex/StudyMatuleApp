package vrsalex.matule.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.show.ShopAppShopCart
import vrsalex.matule.uikit.show.ShowAppBubble
import vrsalex.matule.uikit.show.ShowAppButton
import vrsalex.matule.uikit.show.ShowAppChip
import vrsalex.matule.uikit.show.ShowAppController
import vrsalex.matule.uikit.show.ShowAppHeader
import vrsalex.matule.uikit.show.ShowAppIcon
import vrsalex.matule.uikit.show.ShowAppMenuButton
import vrsalex.matule.uikit.show.ShowAppModalBottomSheet
import vrsalex.matule.uikit.show.ShowAppSearchBar
import vrsalex.matule.uikit.show.ShowAppTextField
import vrsalex.matule.uikit.show.ShowShopSelectorFiled
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Column(modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxSize()
                    .background(White)
                    .imePadding()
                    .verticalScroll(rememberScrollState())) {

                    ShowAppIcon()

                    ShowAppTextField()

                    ShowShopSelectorFiled()

                    ShowAppSearchBar()

                    ShowAppButton()

                    ShowAppChip()

                    ShopAppShopCart()

                    ShowAppBubble()

                    ShowAppMenuButton()

                    ShowAppController()

                    ShowAppHeader()

                    ShowAppModalBottomSheet()

                    Spacer(Modifier.size(200.dp))
                }
            }
        }
    }
}
