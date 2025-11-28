package vrsalex.matuleapp.presentation.navigation.base.graph

import androidx.annotation.Keep
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import vrsalex.matuleapp.presentation.feature.auth.SignInScreen
import vrsalex.matuleapp.presentation.navigation.base.destination.AuthDestination
import vrsalex.matuleapp.presentation.navigation.base.destination.Destination

@Serializable
@Keep
data object AuthGraph: Destination

fun NavGraphBuilder.authGraph(
    navController: NavController
) {
    navigation<AuthGraph>(
        startDestination = AuthDestination.SignIn
    ){

        composable<AuthDestination.SignIn>{
            SignInScreen()
        }

        composable<AuthDestination.SignUp>{

        }

    }
}