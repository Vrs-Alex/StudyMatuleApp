package vrsalex.matule.controller.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import vrsalex.matule.api.endpoints.ServerEndpoints
import vrsalex.matule.api.response.profile.ProfileDataResponse
import vrsalex.matule.application.command.profile.GetProfileDataCommand
import vrsalex.matule.controller.facade.ProfileFacade

@RestController
class ProfileController(
    private val profileFacade: ProfileFacade
) {


    @GetMapping(ServerEndpoints.API.PROFILE_GET_DATA_ENDPOINT)
    fun getProfileData(
        @RequestHeader("Authorization") token: String
    ): ResponseEntity<ProfileDataResponse> {
        val res = profileFacade.getProfileData(GetProfileDataCommand(token))
        return ResponseEntity.ok(res)
    }

}