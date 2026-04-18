package com.example.ets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ets.ui.theme.ETSTheme
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import com.example.ets.adapter.AnimeAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val animeList = listOf(
            Anime(
                "Naruto",
                "https://via.placeholder.com/300",
                "2002",
                "Action",
                "8.5",
                "Cerita ninja dari desa Konoha"
            ),
            Anime(
                "Attack on Titan",
                "https://via.placeholder.com/300",
                "2013",
                "Action, Drama",
                "9.0",
                "Manusia melawan titan"
            )
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = AnimeAdapter(animeList) { anime ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", anime.title)
            intent.putExtra("image", anime.imageUrl)
            intent.putExtra("date", anime.releaseDate)
            intent.putExtra("genre", anime.genre)
            intent.putExtra("rating", anime.rating)
            intent.putExtra("synopsis", anime.synopsis)

            startActivity(intent)
        }
    }
}