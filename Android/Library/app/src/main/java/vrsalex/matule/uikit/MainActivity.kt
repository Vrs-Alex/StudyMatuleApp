package vrsalex.matule.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.component.AppTextField
import vrsalex.matule.uikit.show.ShopAppShopCart
import vrsalex.matule.uikit.show.ShowAppBubble
import vrsalex.matule.uikit.show.ShowAppButton
import vrsalex.matule.uikit.show.ShowAppChip
import vrsalex.matule.uikit.show.ShowAppIcon
import vrsalex.matule.uikit.show.ShowAppSearchBar
import vrsalex.matule.uikit.show.ShowAppTextField
import vrsalex.matule.uikit.show.ShowShopSelectorFiled
import vrsalex.matule.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Column(modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxSize()
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

                    Spacer(Modifier.size(200.dp))
                }
            }
        }
    }
}
