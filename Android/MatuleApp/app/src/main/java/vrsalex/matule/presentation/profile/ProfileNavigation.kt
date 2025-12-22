package vrsalex.matule.presentation.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.presentation.navigation.bottom.ProfileGraph

fun NavGraphBuilder.profileGraph(navController: NavController) {

    navigation<ProfileGraph>(startDestination = ProfileDestination) {

        composable<ProfileDestination>{

        }
    }

}