package vrsalex.matule.domain.usecase.setting

import kotlinx.coroutines.flow.first
import vrsalex.matule.domain.repository.AppSettingRepository
import javax.inject.Inject

class MatchPinCodeUseCase @Inject constructor(
    private val appSettingRepository: AppSettingRepository
) {

    suspend operator fun invoke(currentPinCode: String): Boolean {
        val pinCode = appSettingRepository.getPinCode().first() ?: return true
        return pinCode == currentPinCode
    }

}