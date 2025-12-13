package vrsalex.matule.controller.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import vrsalex.matule.api.endpoints.ServerEndpoints

@RestController
class ProfileController {


    @GetMapping(ServerEndpoints.API.PROFILE_GET_DATA_ENDPOINT)
    fun getProfileData(){

    }

}