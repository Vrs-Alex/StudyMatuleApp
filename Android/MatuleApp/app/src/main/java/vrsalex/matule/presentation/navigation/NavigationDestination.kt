package vrsalex.matule.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

@Serializable
data object LoginRoute

@Serializable
data object CreateAppPasswordRoute

@Serializable
data object CreateProfileRoute

@Serializable
data object VerifyPhoneRoute

@Serializable
data object CreateAccountPasswordRoute


@Serializable
data object MainGraph


@Serializable
sealed interface MainTabRoute

@Serializable
data object HomeGraph: MainTabRoute


@Serializable
data object MainWindowRoute


@Serializable
data object CatalogGraph: MainTabRoute

@Serializable
data object ProjectGraph: MainTabRoute

@Serializable
data object ProfileGraph: MainTabRoute



