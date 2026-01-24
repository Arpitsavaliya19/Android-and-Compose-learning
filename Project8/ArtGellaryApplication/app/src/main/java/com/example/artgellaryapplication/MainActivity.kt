package com.example.artgellaryapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgellaryapplication.ui.theme.ArtGellaryApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGellaryApplicationTheme {
                ArtGellaryApp()
            }
        }
    }
}

@Composable
fun ArtGellaryApp() {

    var currentImage by remember { mutableStateOf(1) }
    val onNext: () -> Unit = {
        if (currentImage <3) {
            currentImage++
        } else {
            currentImage = 1 // Loop back to the first image
        }
    }

    // Explicitly define the type as () -> Unit
    val onPrevious: () -> Unit = {
        if (currentImage > 1) {
            currentImage--
        } else {
            currentImage = 3 // Loop back to the last image
        }
    }

    when (currentImage) {
        1 ->
            ArtImageAndText(
            drawableResourceId = R.drawable.w_eleven,
            contentDescriptionResourceId = R.string.w11contentdiscription,
            artText = R.string.w11,
            artistName = R.string.W11Art,
            onPreviousClick = onPrevious,
                onNextClick = onNext
        )
        2 ->

            ArtImageAndText(
                drawableResourceId = R.drawable.w_twelve,
                contentDescriptionResourceId = R.string.w11contentdiscription,
                artText = R.string.w11,
                artistName = R.string.W11Art,
                onPreviousClick = onPrevious,
                onNextClick = onNext
            )
        3->
            ArtImageAndText(
                drawableResourceId = R.drawable.w_thirteen,
                contentDescriptionResourceId = R.string.w11contentdiscription,
                artText = R.string.w11,
                artistName = R.string.W11Art,
                onPreviousClick = onPrevious,
                onNextClick = onNext
            )
    }
}

@Composable
fun ArtImageAndText(
    modifier: Modifier = Modifier,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    artText :Int,
    artistName: Int,
    onPreviousClick: () -> Unit, // Add this
    onNextClick: () -> Unit

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier
                    .height(600.dp)
                    .fillMaxWidth()
                    .padding(25.dp)
                    .clip(RoundedCornerShape(8.dp))
                    ,colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )

            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(20.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = stringResource(artText),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = stringResource(artistName),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 25.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Button(
                    onClick = {onPreviousClick()},
                    modifier = Modifier
                        .width(120.dp)
                        .height(60.dp)
                        .padding(start = 10.dp)
                ) { Text("Previous")}

                Button(
                    onClick = {onNextClick()},
                    modifier = Modifier
                        .width(120.dp)
                        .height(60.dp)
                        .padding(end = 10.dp)
                ) { Text("Next")}
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ArtGellaryAppPreview() {
    ArtGellaryApp()
}