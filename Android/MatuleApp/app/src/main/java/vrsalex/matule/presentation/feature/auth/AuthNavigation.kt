package vrsalex.matule.presentation.feature.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import vrsalex.matule.presentation.feature.auth.login.LoginScreen
import vrsalex.matule.presentation.feature.auth.profile.CreateProfileScreen
import vrsalex.matule.presentation.feature.auth.verify_phone.VerifyPhoneScreen


fun NavGraphBuilder.authGraph(
    navController: NavController
) {

    navigation<AuthGraph>(
        startDestination = LoginRoute
    ){

        composable<LoginRoute> {
            LoginScreen(
                onNavigateToCreateProfile = {
                    navController.navigate(CreateProfileRoute)
                },
                onNavigateToCreateAppPassword = {
                    navController.navigate(CreateAppPasswordRoute)
                }
            )
        }

        composable<CreateProfileRoute> {
            CreateProfileScreen(
                onNavigateToVerifyPhoneNumber = {
                    navController.navigate(VerifyPhoneRoute)
                }
            )
        }

        composable<VerifyPhoneRoute> {
            VerifyPhoneScreen(onNavigateBack = { navController.popBackStack() }, onNavigateToCreateAppPassword = {
                navController.navigate(CreateAppPasswordRoute)
            }
            )
        }

        composable<CreateAccountPasswordRoute> {

        }


        composable<CreateAppPasswordRoute> {

        }

    }


}