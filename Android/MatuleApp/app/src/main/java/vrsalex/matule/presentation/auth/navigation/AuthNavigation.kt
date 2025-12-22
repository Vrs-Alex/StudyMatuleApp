package vrsalex.matule.presentation.auth.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import vrsalex.matule.presentation.auth.account_password.AccountPasswordScreen
import vrsalex.matule.presentation.auth.app_password.AppPasswordScreen
import vrsalex.matule.presentation.auth.login.LoginScreen
import vrsalex.matule.presentation.auth.profile.CreateProfileScreen
import vrsalex.matule.presentation.auth.verify_phone.VerifyPhoneScreen
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph

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
                onBack = { navController.popBackStack() },
                onRegistrationRestart = {
                    navController.navigate(LoginDestination){
                        popUpTo(AuthGraph){ inclusive = true }
                    }
                }
            )
        }

        composable<CreateAppPasswordDestination> {
            AppPasswordScreen(
                onNext = { navController.navigate(BottomTabsGraph){popUpTo(AuthGraph){ inclusive = true }} },
                onSkip = { navController.navigate(BottomTabsGraph){popUpTo(AuthGraph){ inclusive = true }} }
            )
        }
    }

}