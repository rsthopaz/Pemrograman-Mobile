package com.example.pertemuan_14.data.api

import com.example.pertemuan_14.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")

    suspend fun getTopHeadlines(

        @Query("country")
        country: String = "us",

        @Query("apiKey")
        apiKey: String

    ): NewsResponse
}