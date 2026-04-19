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
import com.example.ets_2.data.DummyData
import com.example.ets_2.ui.components.AnimeItem
@Composable
fun GalleryScreen(navController: NavController) {
    val animeList = DummyData.animeList

    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(2.dp),
        modifier = Modifier.height(280.dp),


    ) {
        items(animeList) { anime ->
            AnimeItem(anime) {
                navController.navigate("detail/${anime.id}")
            }
        }
    }
}