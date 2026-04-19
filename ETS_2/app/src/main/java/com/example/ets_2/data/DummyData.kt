package com.example.ets_2.data

import com.example.ets_2.model.Anime

object DummyData {

    val animeList: List<Anime> = listOf(
        Anime(
            id = 1,
            title = "Naruto",
            imageUrl = "https://via.placeholder.com/150",
            releaseDate = "2002",
            genre = "Action",
            rating = "8.5",
            synopsis = "A ninja story"
        ),
        Anime(
            id = 2,
            title = "One Piece",
            imageUrl = "https://via.placeholder.com/150",
            releaseDate = "1999",
            genre = "Adventure",
            rating = "9.0",
            synopsis = "Pirate adventure"
        )
    )
}