package com.example.navigationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.navigationpractice.ui.theme.NavigationPracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationPracticeTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentScreen = backStackEntry?.destination?.route
                val showButton = currentScreen != NavigationPath.Main.name

                Scaffold(
                    topBar = {
                        NavigationAppBar(
                            isCanClick = showButton,
                            navigateUp = { navController.navigateUp() },
                            currentScreen = NavigationPath.valueOf(
                                currentScreen ?: NavigationPath.Main.name
                            )
                        )
                    }) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavigationPath.Main.name,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(route = NavigationPath.Main.name) {
                            mainScreen(
                                onClick = { navController.navigate(NavigationPath.NestedGraph.name) })
                        }
                        navigation(
                            startDestination = NavigationPath.FirstScreen.name,
                            route = NavigationPath.NestedGraph.name
                        ) {
                            composable(route = NavigationPath.FirstScreen.name) {
                                FirstScreen(
                                    onClick = {
                                        navController.navigate(NavigationPath.SecondScreen.name)
                                    })
                            }
                            composable(route = NavigationPath.SecondScreen.name) {
                                SecondScreen(
                                    onClick = {
                                        navController.navigate(NavigationPath.ThirdScreen.name)
                                    })
                            }
                            composable(route = NavigationPath.ThirdScreen.name) {
                                ThirdScreen(
                                    onClick = {
                                        navController.navigate(NavigationPath.FourthScreen.name)
                                    })
                            }
                            composable(route = NavigationPath.FourthScreen.name) {
                                FourthScreen(onMainClick = {
                                    navController.popBackStack(
                                        route = NavigationPath.Main.name, inclusive = false
                                    )
                                }, onFirstClick = {
                                    navController.popBackStack(
                                        route = NavigationPath.FirstScreen.name, inclusive = false
                                    )
                                }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//val backStackEntry = navController.
//val currentScreen = NavigationPath.valueOf(
//    backStackEntry?.destination?.route ?: NavigationPath.Main.name)

enum class NavigationPath(Screenname: String) {
    Main(Screenname = "Main Screen"),
    NestedGraph(Screenname = "Nested Graph"),
    FirstScreen(Screenname = "First Screen"),
    SecondScreen(Screenname = "Second Screen"),
    ThirdScreen(Screenname = "Third Screen"),
    FourthScreen(Screenname = "Fourth Screen")
}


@Composable
fun mainScreen(onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("This is Main Screen")
        Button(
            onClick = onClick
        ) {
            Text("Towards First Screen ")
        }
    }
}

@Composable
fun FirstScreen(
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "First Screen")
        Button(
            onClick = onClick
        ) {
            Text("Towards Second Screen ")
        }
    }
}

@Composable
fun SecondScreen(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Second Screen")
        Button(
            onClick = onClick
        ) {
            Text("Towards Third Screen ")
        }
    }
}

@Composable
fun ThirdScreen(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Third Screen ")
        Button(
            onClick = onClick
        ) {
            Text("Towards Fourth Screen ")
        }
    }
}

@Composable
fun FourthScreen(
    onMainClick: () -> Unit, onFirstClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Fourth Screen ")
        Button(
            onClick = onMainClick
        ) {
            Text("Return to Main Screen ")
        }
        Button(
            onClick = onFirstClick
        ) {
            Text("Return to First Screen ")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    isCanClick: Boolean,
    currentScreen: NavigationPath,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isCanClick) {
                    IconButton(
                        onClick = { navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack, contentDescription = "Back Button"
                        )
                    }
                }
                Text(text = currentScreen.name)
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.primaryContainer
        )
    )

}



