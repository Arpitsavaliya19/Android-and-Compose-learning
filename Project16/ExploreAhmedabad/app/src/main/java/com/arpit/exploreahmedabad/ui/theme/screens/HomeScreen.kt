package com.arpit.exploreahmedabad.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.arpit.exploreahmedabad.R
import com.arpit.exploreahmedabad.data.dataSource.PlaceCategory
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.ScreensViewmodel.ShareedViewmodel
import com.arpit.exploreahmedabad.ui.theme.navigation.NavRoutes

@Composable
fun HomeScreen(
    navController: NavHostController,
    windowWidhtSize: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel
) {
    when (windowWidhtSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            CompactScreen(navController = navController, viewmodel = viewmodel)
        }
        else -> {
            MediumScreen(navController = navController, viewmodel = viewmodel)
        }
    }

}


@Composable
fun CardItemHistorical(
    onClick: () -> Unit = {}
) {
    val black = Color(0xFF000000) // You can change this to your desired purple color

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.adalaj_stepwell),
                contentDescription = "Historical Building",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, black),
                            startX = 250f // Adjust this value to control the starting point of the gradient
                        )
                    )
            )
            Text(
                "Historical Places",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun CardItemRestaurants(
    onClick: () -> Unit = {}
) {
    val black = Color(0xFF000000) // You can change this to your desired purple color

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.agashiye_restaurant_image),
                contentDescription = "Gujarati Thali with food",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, black),
                            startX = 250f // Adjust this value to control the starting point of the gradient
                        )
                    )
            )

            Text(
                "Restaurants",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun CardItemShopping(
    onClick: () -> Unit = {}
) {
    val black = Color(0xFF000000) // You can change this to your desired purple color

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        onClick = onClick

    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.law_garden_markt),
                contentDescription = "Street Shopping Market Photos",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, black),
                            startX = 250f // Adjust this value to control the starting point of the gradient
                        )
                    )
            )

            Text(
                "Shopping Places",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun CardItemParks(
    onClick: () -> Unit = {}
) {
    val black = Color(0xFF000000) // You can change this to your desired purple color

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.kankriya_lake),
                contentDescription = "Kankriya Lack Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, black),
                            startX = 250f // Adjust this value to control the starting point of the gradient
                        )
                    )
            )

            Text(
                "Nature Parks",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


@Composable
fun CompactScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            CardItemHistorical(onClick = {
                navController.navigate("category/${PlaceCategory.HISTORICAL.name}")
            })
        }
        item {
            CardItemRestaurants(onClick = {
                navController.navigate("category/${PlaceCategory.RESTAURANTS.name}")
            })
        }
        item {
            CardItemShopping(onClick = {
                navController.navigate("category/${PlaceCategory.SHOPPING.name}")
            })
        }
        item {
            CardItemParks(onClick = {
                navController.navigate("category/${PlaceCategory.PARKS.name}")
            })
        }
    }
}

@Composable
fun MediumScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            CardItemHistorical(onClick = {
                navController.navigate("category/${PlaceCategory.HISTORICAL.name}")
            })
        }
        item {
            CardItemRestaurants(onClick = {
                navController.navigate("category/${PlaceCategory.RESTAURANTS.name}")
            })
        }
        item {
            CardItemShopping(onClick = {
                navController.navigate("category/${PlaceCategory.SHOPPING.name}")
            })
        }
        item {
            CardItemParks(onClick = {
                navController.navigate("category/${PlaceCategory.PARKS.name}")
            })
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    ExploreAhmedabadTheme {
        val navController = rememberNavController()
        //HomeScreen(navController = navController)
    }
}

@Preview()
@Composable
fun CardItemPreview() {
    ExploreAhmedabadTheme {
        val navController = rememberNavController()
        CardItemHistorical(onClick = {
            navController.navigate(NavRoutes.DetailScreen.name)
        })
    }
}
