package vrsalex.matule.presentation.feature.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.feature.auth.login.LoginScreen


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
                    navController.navigate(CreateAccountPasswordRoute)
                }
            )
        }

        composable<CreateAppPasswordRoute> {

        }

        composable<CreateProfileRoute> {

        }

        composable<VerifyPhoneRoute> {

        }

        composable<CreateAccountPasswordRoute> {

        }

    }


}