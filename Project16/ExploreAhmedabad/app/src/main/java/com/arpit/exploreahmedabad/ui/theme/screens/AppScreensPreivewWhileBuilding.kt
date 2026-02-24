//package com.arpit.exploreahmedabad.ui.theme.screens
//
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.rememberNavController
//import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
//import com.arpit.exploreahmedabad.ui.theme.component.AppTopBar
//import kotlinx.coroutines.delay
//
//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    var showSplash by remember { mutableStateOf(true) }
//
//    LaunchedEffect(Unit) {
//        delay(2000) // splash duration
//        showSplash = false
//    }
//
//    if (showSplash) {
//        SplashScreen()
//    } else {
//        MainScaffold()
//    }
//
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScaffold() {
//    val NavController = rememberNavController()
//    Scaffold(
//        topBar = {
//            AppTopBar(
//                navController = NavController,
//                isBackEnable = false,
//                currentScreen = "HomeScreen"
//            )
//        }
//    ) { innerPadding ->
//        HomeScreen(
//            navController = NavController,
//            modifier = Modifier.padding(innerPadding),
//            onClick = {}
//        )
//    }
//}
//
//
//@Preview
//@Composable
//private fun MyAppPreview() {
//    ExploreAhmedabadTheme {
//        MyApp()
//    }
//}