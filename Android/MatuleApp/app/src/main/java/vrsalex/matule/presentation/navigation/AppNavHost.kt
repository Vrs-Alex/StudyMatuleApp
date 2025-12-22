package vrsalex.matule.presentation.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import vrsalex.matule.presentation.auth.AuthGraph
import vrsalex.matule.presentation.auth.authGraph
import vrsalex.matule.presentation.catalog.catalogGraph
import vrsalex.matule.presentation.home.homeGraph
import vrsalex.matule.presentation.navigation.bottom.BottomTabsGraph
import vrsalex.matule.presentation.navigation.bottom.HomeGraph
import vrsalex.matule.presentation.profile.profileGraph
import vrsalex.matule.presentation.project.projectGraph
import vrsalex.matule.presentation.setting.appSettingGraph
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.Gradient1
import vrsalex.matule.uikit.theme.Gradient2
import vrsalex.matule.uikit.theme.White

@Composable
fun AppNavHost(navController: NavHostController,
               innerPadding: PaddingValues,
               viewModel: RootNavViewModel = hiltViewModel()) {
    val startDestination by viewModel.startDestination.collectAsStateWithLifecycle()

    AnimatedContent(targetState = startDestination) { startDestination ->
        if (startDestination == null) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Gradient2),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Matule",
                    style = AppTheme.typography.textRegular.copy(
                        fontSize = 40.sp,
                        lineHeight = 64.sp,
                        letterSpacing = 0.sp
                    ),
                    color = White
                )
            }
        } else {
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = startDestination
            ) {
                authGraph(navController)
                appSettingGraph(navController)

                navigation<BottomTabsGraph>(startDestination = HomeGraph) {
                    homeGraph(navController)
                    catalogGraph(navController)
                    projectGraph(navController)
                    profileGraph(navController)
                }
            }
        }
    }
}