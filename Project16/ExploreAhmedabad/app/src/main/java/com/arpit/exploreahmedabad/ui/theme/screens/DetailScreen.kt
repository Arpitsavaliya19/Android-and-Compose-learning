package com.arpit.exploreahmedabad.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arpit.exploreahmedabad.data.dataSource.AhmedabadDataProvider
import com.arpit.exploreahmedabad.data.dataSource.Place
import com.arpit.exploreahmedabad.ui.theme.ExploreAhmedabadTheme
import com.arpit.exploreahmedabad.ui.theme.ScreensViewmodel.ShareedViewmodel

@Composable
fun DetailScreen(
    navController: NavHostController,
    viewmodel: ShareedViewmodel,
    windowWidhtSize: WindowSizeClass,
    modifier: Modifier = Modifier
) {
    val uiState by viewmodel.uiState.collectAsState()

    when (windowWidhtSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            uiState.place?.let {
                DetailCompactScreen(place = it, modifier = modifier)
            }
        }

        WindowWidthSizeClass.Medium -> {
            uiState.place?.let {
                DetailMediumScreen(place = it, modifier = modifier)
            }
        }

        WindowWidthSizeClass.Expanded -> {
            uiState.place?.let {
                DetailExpandedScreen(place = it, modifier = modifier)
            }
        }
    }
}

@Composable
fun DetailCompactScreen(place: Place, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.inversePrimary
            )
            .verticalScroll(rememberScrollState()),
    ) {
        Image(
            painter = painterResource(place.imageResourceId),
            contentDescription = stringResource(place.nameResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = stringResource(place.nameResourceId),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge
            )
            HorizontalDivider(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(place.descriptionResourceId),
                modifier = Modifier.padding(top = 16.dp, bottom = 10.dp),
                textAlign = TextAlign.Start,
            )
            HorizontalDivider(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location Icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
                Text(
                    modifier = Modifier,
                    text = stringResource(place.locationResourceId),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
fun DetailMediumScreen(place: Place, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary)

    ) {
        DetailCompactScreen(place = place)
    }
}

@Composable
fun DetailExpandedScreen(place: Place, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary)
    ) {
        DetailCompactScreen(place = place)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    ExploreAhmedabadTheme {
        val place = AhmedabadDataProvider.place.first()
        DetailCompactScreen(place = place)
    }
}
