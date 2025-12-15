package vrsalex.matule.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import vrsalex.matule.presentation.feature.auth.AuthGraph
import vrsalex.matule.presentation.feature.auth.authGraph

@Composable
fun AppHavHost(navController: NavHostController, padding: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = AuthGraph,
        modifier = Modifier.padding(padding)
    ) {
        authGraph(navController)

    }

}