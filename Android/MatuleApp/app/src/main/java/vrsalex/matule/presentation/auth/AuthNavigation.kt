package vrsalex.matule.presentation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.auth.account_password.AccountPasswordScreen
import vrsalex.matule.presentation.auth.login.LoginScreen
import vrsalex.matule.presentation.auth.profile.CreateProfileScreen

fun NavGraphBuilder.authGraph(navController: NavController) {

    navigation<AuthGraph>(
        startDestination = LoginDestination
    ){
        composable<LoginDestination> {
            LoginScreen(
                onLogin = {
                    navController.navigate(CreateAppPasswordDestination){
                        popUpTo(LoginDestination){ inclusive = true }
                    }
                },
                onRegister = {
                    navController.navigate(CreateAccountPasswordDestination){
                        popUpTo(LoginDestination){ inclusive = true }
                    }
                }
            )
        }

        composable<CreateAccountPasswordDestination> {
            AccountPasswordScreen(
                onNext = {
                    navController.navigate(CreateProfileDestination){
                        popUpTo(CreateAccountPasswordDestination){ inclusive = true }
                    }
                }
            )
        }


        composable<CreateProfileDestination> {
            CreateProfileScreen(
                onCreateProfile = {
                    navController.navigate(CreateAccountPasswordDestination){
                        popUpTo(CreateProfileDestination){ inclusive = true }
                    }
                }
            )
        }


        composable<VerifyAccountDestination> {  }

        composable<CreateAppPasswordDestination> {  }
    }

}