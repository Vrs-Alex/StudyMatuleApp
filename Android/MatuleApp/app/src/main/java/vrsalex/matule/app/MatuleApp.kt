package vrsalex.matule.app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import vrsalex.matule.presentation.navigation.AppNavHost
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun MatuleApp() {
    AppTheme() {
        val navController = rememberNavController()
        Scaffold(
            containerColor = White
        ) { innerPadding ->
            AppNavHost(navController, innerPadding)
        }
    }
}