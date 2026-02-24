package com.arpit.exploreahmedabad.ui.theme.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arpit.exploreahmedabad.data.dataSource.PlaceCategory
import com.arpit.exploreahmedabad.ui.theme.ScreensViewmodel.ShareedViewmodel
import com.arpit.exploreahmedabad.ui.theme.screens.CategoryScreen
import com.arpit.exploreahmedabad.ui.theme.screens.DetailScreen
import com.arpit.exploreahmedabad.ui.theme.screens.HomeScreen
import com.arpit.exploreahmedabad.ui.theme.screens.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    windowWidhtSize : WindowSizeClass,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.SplashScreen.route,
        modifier = modifier
    ) {
        composable(route = NavRoutes.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavRoutes.HomeScreen.route) {
            HomeScreen(navController = navController, windowWidhtSize = windowWidhtSize, viewmodel = viewmodel)
        }
        composable(
            route = NavRoutes.CategoryScreen.route,
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            if (category != null) {
                CategoryScreen(
                    navController = navController,
                    windowWidhtSize = windowWidhtSize,
                    viewmodel = viewmodel,
                    category = PlaceCategory.valueOf(category)
                )
            }
        }
        composable(
            route = NavRoutes.DetailScreen.route,
            arguments = listOf(
                navArgument("placeId") {
                    type = NavType.IntType
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                viewmodel = viewmodel,
                windowWidhtSize = windowWidhtSize
            )
        }
    }
}