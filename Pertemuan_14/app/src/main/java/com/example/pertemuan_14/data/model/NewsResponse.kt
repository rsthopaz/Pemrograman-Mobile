package com.example.pertemuan_14.data.model

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
)