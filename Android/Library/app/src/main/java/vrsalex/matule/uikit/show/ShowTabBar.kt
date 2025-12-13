package vrsalex.matule.uikit.show

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vrsalex.matule.uikit.R
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.component.tabbar.BottomTab
import vrsalex.matule.uikit.component.tabbar.TabBar

@Composable
fun ShowTabBar() {


    Column(
        modifier = Modifier.padding(vertical = 32.dp)
    ) {
        val navController = rememberNavController()

        val bottomTabs = listOf(
            BottomTab<String>(payload = "home", title = "Главная", iconId = R.drawable.tab_home),
            BottomTab<String>(payload = "catalog", title = "Каталог", iconId = R.drawable.tab_catalog),
            BottomTab<String>(payload = "project", title = "Проекты", iconId = R.drawable.tab_project),
            BottomTab<String>(payload = "profile", title = "Профиль", iconId = R.drawable.tab_profile)
        )
        val currentDestination = remember { mutableStateOf<String>("home") }

        TabBar<String>(
            items = bottomTabs,
            isTabSelected = { payload ->
                payload == currentDestination.value
            },
            onTabSelected = { tab ->
                currentDestination.value = tab
            }
        )
    }

}