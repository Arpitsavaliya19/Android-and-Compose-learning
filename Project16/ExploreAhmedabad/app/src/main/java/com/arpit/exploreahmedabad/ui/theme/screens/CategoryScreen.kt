package com.arpit.exploreahmedabad.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.arpit.exploreahmedabad.data.dataSource.AhmedabadDataProvider
import com.arpit.exploreahmedabad.data.dataSource.Place
import com.arpit.exploreahmedabad.data.dataSource.PlaceCategory
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.ScreensViewmodel.ShareedViewmodel

val black = Color(0xFF000000)

@Composable
fun CategoryScreen(
    navController: NavHostController,
    windowWidhtSize: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel,
    category: PlaceCategory
) {

    val uiState by viewmodel.uiState.collectAsState()
    LaunchedEffect(category) {
        viewmodel.updateCategory(category)
    }

    when (windowWidhtSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            CategoryCompactScreen(
                navController = navController,
                viewmodel = viewmodel,
                places = uiState.places
            )
        }

        WindowWidthSizeClass.Medium -> {
            CategoryMediumScreen(
                navController = navController,
                viewmodel = viewmodel,
                places = uiState.places
            )
        }

        WindowWidthSizeClass.Expanded -> {
            CategoryExpandedScreen(
                navController = navController,
                viewmodel = viewmodel,
                windowWidhtSize = windowWidhtSize,
                places = uiState.places
            )
        }
    }
}

@Composable
fun CategoryCompactScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel,
    places: List<Place>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(places) {
            CategoryItem(
                place = it,
                Onclick = {
                    viewmodel.updatePlace(it)
                    navController.navigate("detail/${it.id}")
                }
            )
        }
    }
}

@Composable
fun CategoryMediumScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel,
    places: List<Place>
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
        items(places) {
            CategoryItem(
                place = it,
                Onclick = {
                    viewmodel.updatePlace(it)
                    navController.navigate("detail/${it.id}")
                }
            )
        }
    }
}


@Composable
fun CategoryExpandedScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewmodel: ShareedViewmodel,
    windowWidhtSize: WindowSizeClass,
    places: List<Place>
) {
    Row(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.inversePrimary),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(places) {
                CategoryItem(
                    place = it,
                    Onclick = {
                        viewmodel.updatePlace(it)
                    }
                )
            }
        }
        DetailScreen(
            navController = navController,
            viewmodel = viewmodel,
            windowWidhtSize = windowWidhtSize,
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun CategoryItem(
    place: Place,
    Onclick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        onClick = Onclick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(place.imageResourceId),
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
                text = stringResource(place.nameResourceId),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showSystemUi = true)
@Composable
private fun CategoryScreenPreview() {
    ExploreAhmedabadTheme {
        val navController = rememberNavController()
        val windowSize = WindowSizeClass.calculateFromSize(DpSize(1200.dp, 800.dp))
        val viewModel: ShareedViewmodel = viewModel()
        CategoryScreen(
            navController = navController,
            windowWidhtSize = windowSize,
            viewmodel = viewModel,
            category = PlaceCategory.PARKS
        )
    }
}
