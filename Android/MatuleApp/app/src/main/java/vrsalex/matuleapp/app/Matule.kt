package vrsalex.matuleapp.app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matuleapp.presentation.navigation.base.graph.NavGraph

@Composable
fun Matule() {
    Scaffold(
        containerColor = AppTheme.colors.background,
    ) { paddingValues ->

        val navController = rememberNavController()
       AppTheme() {
           NavGraph(
               navController = navController,
               paddingValues = paddingValues
           )
       }
    }
}