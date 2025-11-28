package vrsalex.matuleapp.presentation.navigation.base.destination

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

object AuthDestination {

    @Serializable
    @Keep
    data object SignIn : Destination

    @Serializable
    @Keep
    data object SignUp : Destination

}