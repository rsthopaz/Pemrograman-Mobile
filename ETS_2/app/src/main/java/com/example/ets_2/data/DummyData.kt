package com.example.ets_2.data

import com.example.ets_2.R
import com.example.ets_2.model.Anime


object DummyData {

    val animeList: List<Anime> = listOf(
        Anime(
            id = 1,
            title = "Naruto",
            season = "Airing",
            eps = "Unknown",
            imageRes = R.drawable.naruto,
            releaseDate = "2002",
            genre = listOf("Action", "Adventure"),
            rating = "8.5",
            synopsis = "A ninja story"
        ),
        Anime(
            id = 2,
            title = "One Piece",
            season = "Airing",
            eps = "Unknown",
            imageRes = R.drawable.onepiece,
            releaseDate = "TV - 1999",
            genre = listOf("Action", "Adventure"),
            rating = "9.0",
            synopsis = "Pirate adventure"
        )
    )
}