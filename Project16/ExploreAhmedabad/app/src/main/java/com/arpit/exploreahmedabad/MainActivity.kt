package com.arpit.exploreahmedabad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.component.AppTopBar
import com.arpit.exploreahmedabad.ui.theme.navigation.AppNavigation
import com.arpit.exploreahmedabad.ui.theme.navigation.NavRoutes

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploreAhmedabadTheme {
                val windowSizeClass = calculateWindowSizeClass(this)

                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                Scaffold(
                    topBar = {
                        if (currentRoute != NavRoutes.SplashScreen.name) {
                            AppTopBar(navController = navController)
                        }
                    }
                ) { innerPadding ->
                    val contentModifier =
                        if (currentRoute != NavRoutes.SplashScreen.name)
                            Modifier.padding(innerPadding)
                        else
                            Modifier
                    AppNavigation(
                        navController = navController,
                        windowWidhtSize = windowSizeClass,
                        modifier = contentModifier
                    )
                }
            }
        }
    }
}
