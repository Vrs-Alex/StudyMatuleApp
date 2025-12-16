package vrsalex.matule.presentation.feature.auth

import kotlinx.serialization.Serializable



@Serializable
data object AuthGraph

@Serializable
data object LoginRoute

@Serializable
data object CreateProfileRoute

@Serializable
data object VerifyPhoneRoute

@Serializable
data object CreateAccountPasswordRoute

@Serializable
data object CreateAppPasswordRoute