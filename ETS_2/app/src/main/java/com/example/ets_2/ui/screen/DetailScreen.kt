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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.ets_2.data.DummyData
import com.example.ets_2.ui.components.AnimeItem
import com.example.ets_2.ui.components.GenreChip

@Composable
fun DetailScreen(animeId: Int) {
    val anime = DummyData.animeList.find { it.id == animeId }

    anime?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Row{

                Image(
                    painter = painterResource(id = anime.imageRes),
                    contentDescription = it.title,
                    modifier = Modifier
                        .width(120.dp)
                        .aspectRatio(0.7f)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))

                Column() {
                    Text(text = it.title)
                    Text(text = "Release: ${it.releaseDate}")
                    Text(text = "Rating: ${it.rating}")

                }
            }

            Row{
                it.genre.forEach { g -> GenreChip(g) }
            }
            Text(text = "Genre: ${it.genre}")
            Text(text = it.synopsis)


        }
    }
}