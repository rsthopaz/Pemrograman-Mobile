package com.example.ets_2.ui.screen
import android.R.attr.text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.navigation.NavController
import androidx.navigation.compose.*
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ets_2.R
import com.example.ets_2.data.DummyData
import com.example.ets_2.model.Anime
import com.example.ets_2.ui.components.AnimeItem
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(
    navController: NavController,
    onToggleDarkMode: () -> Unit
) {
    val animeList = remember { mutableStateListOf<Anime>().apply {
        addAll(DummyData.animeList)
    }}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Anime Gallery") },
                actions = {
                    IconButton(onClick = onToggleDarkMode) {
                        Icon(
                            painter = painterResource(id = R.drawable.dark_theme_svgrepo_com),
                            contentDescription = "Toggle Dark Mode"
                        )
                    }
                }
            )
        },

        // 🔥 FAB (ADD BUTTON)
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // nanti buka dialog add anime
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Anime"
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {

            AnimeSection("Today", animeList.take(5), navController)
            AnimeSection("This Season", animeList.drop(5).take(5), navController)
            AnimeSection("Recommendations", animeList.drop(10).take(6), navController)
        }
    }
}

@Composable
fun AnimeSection(title: String, list: List<Anime>, navController: NavController){

    Column(modifier = Modifier.padding(top = 15.dp)) {

        Text(
            text=title, modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground

        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            contentPadding = PaddingValues(2.dp),
            modifier = Modifier.height(260.dp),


            ) {
            items(list) { anime ->
                AnimeItem(anime) {
                    navController.navigate("detail/${anime.id}")
                }
            }
        }
    }
}