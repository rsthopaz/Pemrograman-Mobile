package com.example.ets_2.data

import com.example.ets_2.R
import com.example.ets_2.model.Anime


object DummyData {

    val animeList: List<Anime> = listOf(
        Anime(
            id = 1,
            title = "Naruto",
            imageRes = R.drawable.naruto,
            releaseDate = "2002",
            genre = "Action",
            rating = "8.5",
            synopsis = "A ninja story"
        ),
        Anime(
            id = 2,
            title = "One Piece",
            imageRes = R.drawable.onepiece,
            releaseDate = "1999",
            genre = "Adventure",
            rating = "9.0",
            synopsis = "Pirate adventure"
        )
    )
}