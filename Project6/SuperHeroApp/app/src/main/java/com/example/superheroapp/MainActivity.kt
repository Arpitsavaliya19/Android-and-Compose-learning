package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.Hero
import com.example.superheroapp.model.HeroesRepository
import com.example.superheroapp.ui.theme.SuperHeroAppTheme
import com.example.superheroapp.ui.theme.md_theme_light_primary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroAppTheme {
                SuperHeroApp()
            }
        }
    }
}


@Composable
fun SuperHeroApp() {
    Scaffold(
        topBar = {AppTopAppBar()}
    ) {  innerpadding ->
        HeroList(modifier = Modifier.padding(innerpadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .background(color = md_theme_light_primary)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Super Hero",
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.White
                )
            }
        }
    )
}
//  function is a whole component of the one hero in the list
@Composable
fun HeroElevetedCard(
    superhero : Hero,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFFDDE6C6)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeroInformation(superhero.nameRes,
                superhero.descriptionRes,
                modifier = Modifier.weight(1f)
            )
            HeroIcon(superhero.imageRes)
        }
    }
}



/// this function is for heroes list in the application
@Composable
fun HeroList(modifier: Modifier = Modifier) {

    val heroes = HeroesRepository.heroes

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(heroes){it->
            HeroElevetedCard(
                superhero = it,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}



// function is for image of hero in the list
@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(heroIcon),
        contentDescription = null,
        modifier  = Modifier
            .height(72.dp)
            .width(72.dp)
            .clip(RoundedCornerShape(8.dp)),
    )
}



// function for information of hero in the list
@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 16.dp)
    ) {
        Text(text = stringResource(id=heroName),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(id=heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
