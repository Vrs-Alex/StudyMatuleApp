package vrsalex.matule.presentation.navigation.bottom

import kotlinx.serialization.Serializable



@Serializable
data object MainGraph


@Serializable
sealed interface MainTabRoute

@Serializable
data object HomeGraph: MainTabRoute


@Serializable
data object CatalogGraph: MainTabRoute

@Serializable
data object ProjectGraph: MainTabRoute

@Serializable
data object ProfileGraph: MainTabRoute



