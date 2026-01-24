package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courseapp.data.DataSource
import com.example.courseapp.data.Topic
import com.example.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseAppTheme {
                CoureseApp()
            }
        }
    }
}

@Composable
fun CoureseApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(DataSource.topics) {topic->
                TopicCard(topic = topic)
            }
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
    ) {
        Row() {
            Image(
                painter = painterResource(id=topic.imageResourceId ),
                contentDescription = stringResource(id=topic.stringResourceId),
                modifier = Modifier
                    .size(68.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop,

                )
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,end = 16.dp, bottom = 8.dp
                )
            ) {
                Text(
                    text = stringResource(topic.stringResourceId),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseAppPreview() {
    CoureseApp()
}