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
import vrsalex.matule.presentation.navigation.bottom.ProjectGraph
import vrsalex.matule.presentation.project.view.ProjectDestination
import vrsalex.matule.presentation.project.view.ProjectScreen

fun NavGraphBuilder.projectGraph(navController: NavController) {

    navigation<ProjectGraph>(startDestination = ProjectDestination) {

        composable<ProjectDestination>{
            ProjectScreen()
        }
    }

}