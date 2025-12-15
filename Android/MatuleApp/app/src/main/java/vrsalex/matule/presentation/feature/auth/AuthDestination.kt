package vrsalex.matule.presentation.feature.auth

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthRoute

@Serializable
data object AuthGraph

@Serializable
data object LoginRoute: AuthRoute

@Serializable
data object CreateProfileRoute: AuthRoute

@Serializable
data object VerifyPhoneRoute: AuthRoute

@Serializable
data object CreateAccountPasswordRoute: AuthRoute

@Serializable
data object CreateAppPasswordRoute: AuthRoute