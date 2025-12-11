package vrsalex.matule.uikit.component.tabbar

import vrsalex.matule.uikit.R

sealed class BottomTab (val route: String, val title: String, val iconId: Int){

    object Home: BottomTab("home", "Главная", R.drawable.tab_home)

    object Catalog: BottomTab("catalog", "Каталог", R.drawable.tab_catalog)

    object Project: BottomTab("project", "Проекты", R.drawable.tab_project)

    object Profile: BottomTab("profile", "Профиль", R.drawable.tab_profile)

}