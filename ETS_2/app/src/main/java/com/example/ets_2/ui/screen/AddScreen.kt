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
fun AddScreen(
    navController: NavController,
    animeList: MutableList<Anime>
) {

    var title by remember { mutableStateOf("") }
    var season by remember { mutableStateOf("") }
    var eps by remember { mutableStateOf("") }
    var release by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }

    var type by remember { mutableStateOf("") }
    var aired by remember { mutableStateOf("") }
    var premiered by remember { mutableStateOf("") }
    var producers by remember { mutableStateOf("") }
    var licensors by remember { mutableStateOf("") }
    var studio by remember { mutableStateOf("") }
    var source by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var pgrating by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }

    var selectedImage by remember { mutableStateOf<String?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImage = uri?.toString()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Add Anime") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text("Main Information", fontWeight = FontWeight.Bold)

            OutlinedTextField(title, { title = it }, label = { Text("Title") })
            OutlinedTextField(season, { season = it }, label = { Text("Season") })
            OutlinedTextField(eps, { eps = it }, label = { Text("Episodes") })

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { imagePicker.launch("image/*") }) {
                Text("Pick Image")
            }

            if (selectedImage != null) {
                Text("Image selected ✓")
            }

            OutlinedTextField(release, { release = it }, label = { Text("Release Date") })
            OutlinedTextField(rating, { rating = it }, label = { Text("Rating") })

            Spacer(modifier = Modifier.height(16.dp))

            Text("More Information", fontWeight = FontWeight.Bold)

            OutlinedTextField(synopsis, { synopsis = it }, label = { Text("Synopsis") })
            OutlinedTextField(type, { type = it }, label = { Text("Type") })
            OutlinedTextField(aired, { aired = it }, label = { Text("Aired") })
            OutlinedTextField(premiered, { premiered = it }, label = { Text("Premiered") })
            OutlinedTextField(producers, { producers = it }, label = { Text("Producers") })
            OutlinedTextField(licensors, { licensors = it }, label = { Text("Licensors") })
            OutlinedTextField(studio, { studio = it }, label = { Text("Studio") })
            OutlinedTextField(source, { source = it }, label = { Text("Source") })
            OutlinedTextField(duration, { duration = it }, label = { Text("Duration") })
            OutlinedTextField(pgrating, { pgrating = it }, label = { Text("PG Rating") })
            OutlinedTextField(genre, { genre = it }, label = { Text("Genre") })


            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    animeList.add(
                        Anime(
                            id = (0..99999).random(),
                            title = title,
                            season = season,
                            eps = eps,
                            imageUri = selectedImage ?: "",
                            releaseDate = release,
                            genre = genre.split(",").map { it.trim() },
                            rating = rating,
                            synopsis = synopsis,
                            type = type,
                            aired = aired,
                            premiered = premiered,
                            producers = producers,
                            licensors = licensors,
                            studio = studio,
                            source = source,
                            duration = duration,
                            pgrating = pgrating
                        )
                    )

                    navController.popBackStack()
                }
            ) {
                Text("Save")
            }
        }
    }
}