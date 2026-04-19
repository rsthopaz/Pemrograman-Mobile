package com.example.ets_2.ui.screen
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.navigation.NavController
import androidx.navigation.compose.*
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.ui.res.painterResource
import com.example.ets_2.data.DummyData
import com.example.ets_2.ui.components.AnimeItem
@Composable
fun DetailScreen(animeId: Int) {
    val anime = DummyData.animeList.find { it.id == animeId }

    anime?.let {
        Column(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(id = anime.imageRes),
                contentDescription = it.title,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            Text(text = it.title)
            Text(text = "Release: ${it.releaseDate}")
            Text(text = "Genre: ${it.genre}")
            Text(text = "Rating: ${it.rating}")
            Text(text = it.synopsis)
        }
    }
}