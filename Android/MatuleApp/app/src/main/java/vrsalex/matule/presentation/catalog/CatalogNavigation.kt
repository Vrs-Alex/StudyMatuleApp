package vrsalex.matule.presentation.catalog

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.navigation.bottom.CatalogGraph
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.presentation.navigation.bottom.ProfileGraph

fun NavGraphBuilder.catalogGraph(navController: NavController) {

    navigation<CatalogGraph>(startDestination = CatalogDestination) {

        composable<CatalogDestination>{

        }
    }

}