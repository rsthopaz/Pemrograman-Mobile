package com.example.ets_2.ui.screen
import android.R.attr.text
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ets_2.data.DummyData
import com.example.ets_2.model.Anime
import com.example.ets_2.ui.components.AnimeItem
@Composable
fun GalleryScreen(navController: NavController) {
    val animelist = DummyData.animeList

    val todaylist = animelist.take(5)
    val thisseasonlist = animelist.drop(5).take(5)
    val recommendationlist = animelist.drop(10). take(5)

    Column(modifier = Modifier.padding(top = 20.dp)) {
        AnimeSection("Today", todaylist, navController)
        AnimeSection("This Season", thisseasonlist, navController)
        AnimeSection("Recommendations", recommendationlist, navController)

    }
}

@Composable
fun AnimeSection(title: String, list: List<Anime>, navController: NavController){

    Column(modifier = Modifier.padding(top = 15.dp)) {

        Text(
            text=title, modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            contentPadding = PaddingValues(2.dp),
            modifier = Modifier.height(240.dp),


            ) {
            items(list) { anime ->
                AnimeItem(anime) {
                    navController.navigate("detail/${anime.id}")
                }
            }
        }
    }
}