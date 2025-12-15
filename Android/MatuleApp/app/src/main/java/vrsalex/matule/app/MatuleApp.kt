package vrsalex.matule.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vrsalex.matule.presentation.feature.auth.authGraph
import vrsalex.matule.presentation.navigation.AppHavHost

import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun MatuleApp() {
    AppTheme() {
        val navController = rememberNavController()
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination

        Scaffold(
            containerColor = White,
            bottomBar = {

            }
        ) { innerPadding ->
            AppHavHost(navController, innerPadding)
        }
    }
}