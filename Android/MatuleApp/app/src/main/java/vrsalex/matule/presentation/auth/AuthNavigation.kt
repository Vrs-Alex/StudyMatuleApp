package vrsalex.matule.presentation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.auth.account_password.AccountPasswordScreen
import vrsalex.matule.presentation.auth.login.LoginScreen
import vrsalex.matule.presentation.auth.profile.CreateProfileScreen
import vrsalex.matule.presentation.auth.verify_phone.VerifyPhoneScreen

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
                        popUpTo(CreateAccountPasswordDestination){ inclusive = false }
                    }
                }
            )
        }


        composable<CreateProfileDestination> {
            CreateProfileScreen(
                onCreateProfile = {
                    navController.navigate(VerifyAccountDestination){
                        popUpTo(CreateProfileDestination){ inclusive = false }
                    }
                }
            )
        }


        composable<VerifyAccountDestination> {
            VerifyPhoneScreen(
                onNext = {
                    navController.navigate(CreateAppPasswordDestination){
                        popUpTo(AuthGraph){ inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable<CreateAppPasswordDestination> {

        }
    }

}