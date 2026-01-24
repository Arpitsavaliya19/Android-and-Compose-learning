@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.model.Days
import com.example.a30daysapp.model.days
import com.example.a30daysapp.ui.theme.AppTheme
import com.example.a30daysapp.ui.theme.inverseOnSurfaceLight
import com.example.a30daysapp.ui.theme.inverseSurfaceLight
import com.example.a30daysapp.ui.theme.secondaryContainerLight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    Days30App()
                }
            }
        }
    }
}

@Composable
fun Days30App() {
    Scaffold(
        containerColor = secondaryContainerLight,
        topBar = {
            Days30AppTopAppBar()
        }
    ) { innerpadding ->
        Days30AppList(
            modifier = Modifier.padding(innerpadding)
        )
    }
}


@Composable
fun Days30AppList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(days) { it ->
            Days30AppCard(itemday = it)
        }
    }
}

@Composable
fun Days30AppCard(
    modifier: Modifier = Modifier,
    itemday: Days
) {

    var enabled by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                onClick = {
                    enabled = !enabled
                }
            )
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        colors = CardDefaults.cardColors(
            containerColor = inverseOnSurfaceLight
        )

    ) {
        Column(

        ) {
            Text(
                text = stringResource(itemday.titleResourceId),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                fontFamily = FontFamily(Font(R.font.cabin_condensed_bold))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(itemday.smalldescriptionId),
                modifier = Modifier.padding(start = 8.dp, bottom = 10.dp),
                fontFamily = FontFamily(Font(R.font.cabin_condensed_regular))
            )
            Image(
                painter = painterResource(itemday.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            if (enabled) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(itemday.stringResourceId),
                    fontFamily = FontFamily
                        (Font(R.font.cabin_condensed_regular)),
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp
                    )
                )
            }
        }
    }
}

@Composable
fun Days30AppTopAppBar() {

    AppTheme() {

        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = inverseSurfaceLight,
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Days30AppPreview() {
    AppTheme {
        Days30App()
    }
}
