package vrsalex.matule.app

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vrsalex.matule.presentation.auth.AuthGraph
import vrsalex.matule.presentation.home.HomeDestination
import vrsalex.matule.presentation.navigation.AppNavHost
import vrsalex.matule.presentation.navigation.bottom.BottomTabGraphs
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph
import vrsalex.matule.presentation.navigation.bottom.CatalogGraph
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.presentation.navigation.bottom.ProfileGraph
import vrsalex.matule.presentation.navigation.bottom.ProjectGraph
import vrsalex.matule.presentation.setting.VerifyPinCodeDestination
import vrsalex.matule.uikit.R
import vrsalex.matule.uikit.component.tabbar.BottomTab
import vrsalex.matule.uikit.component.tabbar.TabBar
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun MatuleApp() {
    AppTheme() {
        val navController = rememberNavController()
        val currentDestination = navController.currentBackStackEntryAsState()
            .value?.destination



        val showBottomSheet = currentDestination?.hierarchy?.any() { it.hasRoute<BottomTabsGraph>() } ?: false
        Scaffold(
            containerColor = White,
            bottomBar = {
                AnimatedContent(showBottomSheet) { showBottomSheet ->
                    if (showBottomSheet) {
                        val items = remember {
                            listOf<BottomTab<BottomTabGraphs>>(
                                BottomTab(HomeGraph, "Главная", R.drawable.tab_home),
                                BottomTab(CatalogGraph, "Каталог", R.drawable.tab_catalog),
                                BottomTab(ProjectGraph, "Проекты", R.drawable.tab_project),
                                BottomTab(ProfileGraph, "Профиль", R.drawable.tab_profile),
                            )
                        }
                        TabBar(
                            items = items,
                            isTabSelected = { route ->
                                currentDestination!!.hierarchy.any {
                                    it.hasRoute(route::class)
                                }
                            },
                            onTabSelected = { route ->
                                navController.navigate(route) {
                                    popUpTo(HomeDestination) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            AppNavHost(navController, innerPadding)
        }
    }
}