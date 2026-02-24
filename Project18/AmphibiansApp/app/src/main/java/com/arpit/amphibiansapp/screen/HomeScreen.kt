package com.arpit.amphibiansapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arpit.amphibiansapp.R
import com.arpit.amphibiansapp.model.Amphibian

@Composable
fun HomeScreen(
    amphibianUIstate: AmphibianUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contetnpadding: PaddingValues = PaddingValues(0.dp)
) {
    when (amphibianUIstate) {
        is AmphibianUIState.Loading -> LoadingScreen(modifier)
        is AmphibianUIState.Success -> AmphbianDetailScreen(amphibianUIstate.Detail,modifier)
        is AmphibianUIState.Error -> ErrorScreen(retryAction, modifier)
        else -> {}
    }
}

@Composable
fun AmphbianDetailCard(
    detail: Amphibian,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(500.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = detail.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = detail.type,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(detail.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = detail.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = detail.description)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.loading_img),
            contentDescription = "Loading Image",
            modifier = Modifier.size(250.dp)
        )
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.ic_connection_error),
            contentDescription = "Error"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Please check you internet connection"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = retryAction,
            modifier = modifier,
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.White
            )
        ) {
            Text(
                "Try Again"
            )
        }

    }
}

@Composable
fun AmphbianDetailScreen(
    Detail: List<Amphibian>,
    modifier: Modifier = Modifier,
    contetnpadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
        contentPadding = contetnpadding
    ) {
        items(
            items = Detail,
            key = { amphibian -> amphibian.name },
        ){detail->
            AmphbianDetailCard(
                detail,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen()
}

@Preview(showSystemUi = true)
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(retryAction = {})
}

@Preview(showSystemUi = true)
@Composable
private fun AmphbianDetailScreenPreview() {
    //AmphbianDetailScreen()
}
