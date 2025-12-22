package vrsalex.matule.presentation.navigation.bottom

import kotlinx.serialization.Serializable

@Serializable
data object BottomTabsGraph

sealed interface BottomTabGraphs

@Serializable
data object HomeGraph: BottomTabGraphs

@Serializable
data object CatalogGraph: BottomTabGraphs

@Serializable
data object ProjectGraph: BottomTabGraphs

@Serializable
data object ProfileGraph: BottomTabGraphs