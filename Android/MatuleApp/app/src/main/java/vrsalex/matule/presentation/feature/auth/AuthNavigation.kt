package vrsalex.matule.presentation.feature.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation



fun NavGraphBuilder.authGraph(
    navController: NavController
) {

    navigation<AuthGraph>(
        startDestination = LoginRoute
    ){

        composable<LoginRoute> {

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