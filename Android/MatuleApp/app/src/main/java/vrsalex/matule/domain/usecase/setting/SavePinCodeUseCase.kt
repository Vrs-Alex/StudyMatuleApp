package vrsalex.matule.domain.usecase.setting

import vrsalex.matule.domain.repository.AppSettingRepository
import javax.inject.Inject

class SavePinCodeUseCase @Inject constructor(
    private val appSettingRepository: AppSettingRepository
) {
    suspend operator fun invoke(pinCode: String) = appSettingRepository.savePinCode(pinCode)
}