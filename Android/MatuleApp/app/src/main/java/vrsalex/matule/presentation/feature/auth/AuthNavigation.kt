package vrsalex.matule.presentation.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.navigation.AuthGraph
import vrsalex.matule.presentation.navigation.CreateAccountPasswordRoute
import vrsalex.matule.presentation.navigation.CreateAppPasswordRoute
import vrsalex.matule.presentation.navigation.CreateProfileRoute
import vrsalex.matule.presentation.navigation.LoginRoute
import vrsalex.matule.presentation.navigation.VerifyPhoneRoute


fun NavGraphBuilder.authGraph() {

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