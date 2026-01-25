package com.example.typesafenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.typesafenavigation.ui.theme.TypeSafeNavigationTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeNavigationTheme {
                NavigationApp()
            }
        }
    }
}


@Composable
fun NavigationApp(
) {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination


    Scaffold(
        topBar = {
            NavigationAppBar(
                isCanClick = currentDestination?.route != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<MainScreen> {
                mainScreen(
                    onClick = { navController.navigate(AuthGraph) }
                )
            }
            navigation<AuthGraph>(
                startDestination = SignUp
            ) {
                composable<SignUp> {
                    SignUpScreen(
                        onClick = { navController.navigate(Login) }
                    )
                }
                composable<Login> {
                    LoginScreen(
                        onClick = { navController.navigate(HomeGraph) }
                    )
                }
            }
            navigation<HomeGraph>(
                startDestination = Home
            ) {
                composable<Home> {
                    HomeScreen(
                        onClick = { navController.navigate(Profile) }
                    )
                }
                composable<Profile> {
                    ProfileScreen(
                        onMainClick = {
                            navController.popBackStack(
                                route = MainScreen,
                                inclusive = false
                            )
                        },
                        onLoginClick = {
                            navController.popBackStack(
                                route = Login,
                                inclusive = false
                            )
                        }
                    )
                }
            }
        }
    }
}

@Serializable
object MainScreen
@Serializable
object AuthGraph
@Serializable
object SignUp
@Serializable
object HomeGraph
@Serializable
object Login
@Serializable
object Home
@Serializable
object Profile

@Composable
fun mainScreen(onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("This is Main Screen")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onClick
        ) {
            Text("Go To Login ")
        }
    }
}

@Composable
fun SignUpScreen(
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Sign UP Screen")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onClick
        ) {
            Text("Go To Login screen")
        }
    }
}

@Composable
fun LoginScreen(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Login Successful")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onClick
        ) {
            Text("Go To Home Screen")
        }
    }
}

@Composable
fun HomeScreen(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onClick
        ) {
            Text("Go To Profile Screen")
        }
    }
}

@Composable
fun ProfileScreen(
    onMainClick: () -> Unit, onLoginClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Profile Screen")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onMainClick
        ) {
            Text("Return to Main Screen ")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onLoginClick
        ) {
            Text("Return to Login Screen ")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    isCanClick: Boolean,
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
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.primaryContainer
        )
    )

}
