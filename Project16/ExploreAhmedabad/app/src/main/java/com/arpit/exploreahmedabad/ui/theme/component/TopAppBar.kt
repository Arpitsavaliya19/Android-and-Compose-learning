package com.arpit.exploreahmedabad.ui.theme.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arpit.exploreahmedabad.R
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.navigation.NavRoutes
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavHostController,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val arguments = backStackEntry?.arguments

    val title = when {
        currentRoute == NavRoutes.HomeScreen.route ->
            "Explorer Ahmedabad"

        currentRoute?.startsWith("category/") == true -> {
            arguments?.getString("category") ?: ""
        }

        currentRoute?.startsWith("detail/") == true -> {
            val id = arguments?.getInt("placeId")
            val place =
                com.arpit.exploreahmedabad.data.dataSource.AhmedabadDataProvider.place.find { it.id == id }

            place.let {
                androidx.compose.ui.res.stringResource(it!!.nameResourceId)
            }
        }
        else->""
    }
    val isBackEnable = currentRoute != NavRoutes.HomeScreen.route &&
            currentRoute !== NavRoutes.SplashScreen.route
    val topBarColor = MaterialTheme.colorScheme.primary
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = topBarColor,
            darkIcons = false
        )
    }


    TopAppBar(
        title = {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (isBackEnable) {
                    IconButton(
                        modifier = Modifier,
                        onClick = {navController.popBackStack()},
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "MenuIcon"
                        )
                    }
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun AppTopBarPreview() {
    ExploreAhmedabadTheme {
        val NavController = rememberNavController()
        AppTopBar(
            navController = NavController,
        )
    }
}
