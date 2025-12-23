package vrsalex.matule.domain.repository

interface ProfileRepository {

    suspend fun syncProfile()

}