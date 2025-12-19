package vrsalex.matule.presentation.setting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.home.HomeGraph
import vrsalex.matule.presentation.setting.pincode.VerifyPinCodeScreen

fun NavGraphBuilder.appSettingGraph(navController: NavController) {

    composable<VerifyPinCodeDestination> {
        VerifyPinCodeScreen(
            onNext = {
                navController.navigate(HomeGraph)
            }
        )
    }


}