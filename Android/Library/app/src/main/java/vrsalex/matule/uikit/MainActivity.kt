package vrsalex.matule.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vrsalex.matule.uikit.show.ShowButton
import vrsalex.matule.uikit.show.ShowControllers
import vrsalex.matule.uikit.show.ShowInput
import vrsalex.matule.uikit.show.ShowSystemIcon
import vrsalex.matule.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Column(
                    modifier = Modifier.fillMaxSize().statusBarsPadding().padding(horizontal = 16.dp, vertical = 32.dp),
                ) {
                    ShowSystemIcon()

                    Spacer(modifier = Modifier.height(32.dp))

                    ShowControllers()

                    Spacer(modifier = Modifier.height(32.dp))

                    ShowButton()

                    Spacer(modifier = Modifier.height(32.dp))

                    ShowInput()
                }
            }
        }
    }
}
