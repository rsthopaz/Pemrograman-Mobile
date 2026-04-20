package com.example.ets_2.model
data class Anime(
    val id: Int,
    val title: String,
    val season: String,
    val eps: String,
    val imageUri: String,
    val releaseDate: String,
    val genre: List<String>,
    val rating: String,
    val synopsis: String,

    // more informations
    val type: String,
    val aired: String,
    val premiered: String,
    val producers: String,
    val licensors: String,
    val studio : String,
    val source: String,
    val duration: String,
    val pgrating: String
)