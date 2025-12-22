package vrsalex.matule.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.auth.CreateAppPasswordDestination
import vrsalex.matule.presentation.home.test.HomeTestViewModel
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import javax.inject.Inject

fun NavGraphBuilder.homeGraph(navController: NavController) {

    navigation<HomeGraph>(startDestination = HomeDestination) {

        composable<HomeDestination>{
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val homeTestViewModel = hiltViewModel<HomeTestViewModel>()
                val text = homeTestViewModel.text.collectAsStateWithLifecycle()
                AppButton(
                    buttonSize = ButtonSize.BIG,
                    buttonType = ButtonType.PRIMARY,
                    onClick = {
                        homeTestViewModel.click()
                    },
                    text = text.value
                )
            }
        }
    }

}