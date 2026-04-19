package com.example.ets_2.model
data class Anime(
    val id: Int,
    val title: String,
    val season: String,
    val eps: String,
    val imageRes: Int,
    val releaseDate: String,
    val genre: List<String>,
    val rating: String,
    val synopsis: String
)