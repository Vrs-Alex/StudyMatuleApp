package vrsalex.matule.domain.usecase.profile

import kotlinx.coroutines.delay
import vrsalex.matule.domain.repository.ProfileRepository
import javax.inject.Inject

class SyncProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    suspend operator fun invoke() {
        profileRepository.syncProfile()
    }

}