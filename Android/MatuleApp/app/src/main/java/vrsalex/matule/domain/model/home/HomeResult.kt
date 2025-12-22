package vrsalex.matule.domain.model.home

sealed interface HomeResult {

    data object Success : HomeResult
    data object Error : HomeResult

}