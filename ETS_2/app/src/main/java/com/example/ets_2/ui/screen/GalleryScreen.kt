package com.example.ets_2.ui.screen
import android.R.attr.text
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
    animeList: MutableList<Anime>,
    onToggleDarkMode: () -> Unit
) {


    var showDialog by remember { mutableStateOf(false) }
    var selectedImage by remember { mutableStateOf<String?>(null) }

    // 📷 IMAGE PICKER
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImage = uri?.toString()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Anime Gallery") },
                actions = {
                    IconButton(onClick = onToggleDarkMode) {
                        Icon(
                            painter = painterResource(id = R.drawable.dark_theme_svgrepo_com),
                            contentDescription = "Dark Mode"
                        )
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            AnimeSection("Today", animeList.take(5), navController)
            AnimeSection("This Season", animeList.drop(5).take(5), navController)
            AnimeSection("Recommendations", animeList.drop(10).take(6), navController)
        }

        // 🧾 ADD DIALOG
        if (showDialog) {
            AddAnimeDialog(
                imagePicker = imagePicker,
                selectedImage = selectedImage,
                onDismiss = {
                    showDialog = false
                    selectedImage = null
                },
                onAdd = { newAnime ->
                    animeList.add(newAnime)
                }
            )
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
            modifier = Modifier.height(250.dp),


            ) {
            items(list) { anime ->
                AnimeItem(anime) {
                    navController.navigate("detail/${anime.id}")
                }
            }
        }
    }
}

@Composable
fun AddAnimeDialog(
    imagePicker: ActivityResultLauncher<String>,
    selectedImage: String?,
    onDismiss: () -> Unit,
    onAdd: (Anime) -> Unit
) {

    var title by remember { mutableStateOf("") }
    var season by remember { mutableStateOf("") }
    var eps by remember { mutableStateOf("") }
    var release by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Anime") },
        text = {
            Column {

                OutlinedTextField(title, { title = it }, label = { Text("Title") })
                OutlinedTextField(season, { season = it }, label = { Text("Season") })
                OutlinedTextField(eps, { eps = it }, label = { Text("Episodes") })

                Spacer(modifier = Modifier.height(10.dp))

                // 📷 PICK IMAGE BUTTON
                Button(onClick = {
                    imagePicker.launch("image/*")
                }) {
                    Text("Pick Image")
                }

                if (selectedImage != null) {
                    Text("Image selected ✓")
                }

                OutlinedTextField(release, { release = it }, label = { Text("Release") })
                OutlinedTextField(rating, { rating = it }, label = { Text("Rating") })
                OutlinedTextField(synopsis, { synopsis = it }, label = { Text("Synopsis") })
            }
        },
        confirmButton = {
            Button(onClick = {
                onAdd(
                    Anime(
                        id = (0..99999).random(),
                        title = title,
                        season = season,
                        eps = eps,
                        imageUri = selectedImage ?: "",
                        releaseDate = release,
                        genre = listOf("New"),
                        rating = rating,
                        synopsis = synopsis,
                        type = "",
                        aired = "",
                        premiered = "",
                        producers = "",
                        licensors = "",
                        studio = "",
                        source = "",
                        duration = "",
                        pgrating = ""
                    )
                )
                onDismiss()
            }) {
                Text("Add")
            }
        }
    )
}