package com.arpit.exploreahmedabad.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.arpit.exploreahmedabad.R
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.navigation.NavRoutes
import com.arpit.exploreahmedabad.ui.theme.splash_screen_background
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        delay(1500) // 2 seconds

        navController.navigate(NavRoutes.HomeScreen.route)
        {
            popUpTo(NavRoutes.SplashScreen.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF8E4D2E))
            .padding(50.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.splash_screen_photo),
                contentDescription = "splash_screen_photo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(200.dp)
                    .width(220.dp)
            )

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayMedium,
                color = Color.White,
                maxLines = 2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Ahmedabad – Let Us Surprise You",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    ExploreAhmedabadTheme {
        val navController = rememberNavController()
        SplashScreen( navController = navController
        )
    }
}
