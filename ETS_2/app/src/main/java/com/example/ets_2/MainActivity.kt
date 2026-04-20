package com.example.ets_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ets_2.ui.theme.ETS_2Theme
import androidx.navigation.compose.*
import com.example.ets_2.ui.screen.GalleryScreen
import com.example.ets_2.ui.screen.DetailScreen
import com.example.ets_2.data.DummyData
import com.example.ets_2.model.Anime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var darkMode by remember { mutableStateOf(false) }

            ETS_2Theme(darkTheme = darkMode) {
                AppNavigation(
                    darkMode = darkMode,
                    onToggleDarkMode = { darkMode = !darkMode }
                )
            }
        }
    }
}

@Composable
fun AppNavigation(
    darkMode: Boolean,
    onToggleDarkMode: () -> Unit
) {
    val navController = rememberNavController()

    val animeList = remember {
        mutableStateListOf<Anime>().apply {
            addAll(DummyData.animeList)
        }
    }

    NavHost(navController, startDestination = "gallery") {

        composable("gallery") {
            GalleryScreen(navController = navController,
                animeList = animeList,
                onToggleDarkMode = onToggleDarkMode
                )
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0

            DetailScreen(
                animeId = id,
                animeList = animeList,
                navController = navController,
                onToggleDarkMode = onToggleDarkMode
            )
        }
    }
}