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
import vrsalex.matule.uikit.component.tabbar.BottomTab
import vrsalex.matule.uikit.component.tabbar.TabBar

@Composable
fun ShowTabBar() {


    Column(
        modifier = Modifier.padding(vertical = 32.dp)
    ) {
        val navController = rememberNavController()

        val bottomTabs = listOf(
            BottomTab.Home,
            BottomTab.Catalog,
            BottomTab.Project,
            BottomTab.Profile
        )

//        val navBackStackEntry by navController.currentBackStackEntryAsState()
        var currentRoute by remember { mutableStateOf( bottomTabs.first().route) }

        TabBar(
            items = bottomTabs,
            currentRoute = currentRoute,
            onTabSelected = { tab ->
                currentRoute = tab.route
            }
        )
    }

}