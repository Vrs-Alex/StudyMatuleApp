package vrsalex.matule.presentation.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.presentation.navigation.bottom.ProfileGraph
import vrsalex.matule.presentation.navigation.bottom.ProjectGraph
import vrsalex.matule.presentation.profile.ProfileDestination

fun NavGraphBuilder.projectGraph(navController: NavController) {

    navigation<ProjectGraph>(startDestination = ProjectDestination) {

        composable<ProjectDestination>{
            Column(Modifier.fillMaxSize()) {
                LazyColumn() {
                    items(1000){
                        Text(text = "Project $it")
                    }
                }
            }
        }
    }

}