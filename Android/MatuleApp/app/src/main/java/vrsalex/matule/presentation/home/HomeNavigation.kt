package vrsalex.matule.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.navigation.bottom.HomeGraph

fun NavGraphBuilder.homeGraph(navController: NavController) {

    navigation<HomeGraph>(startDestination = HomeDestination) {

        composable<HomeDestination>{
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

            }
        }
    }

}