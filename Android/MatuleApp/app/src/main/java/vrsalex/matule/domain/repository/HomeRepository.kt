package vrsalex.matule.domain.repository

import vrsalex.matule.domain.model.home.HomeResult

interface HomeRepository {

    suspend fun test(): HomeResult

}