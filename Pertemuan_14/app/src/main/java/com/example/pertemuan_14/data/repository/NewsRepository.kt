package com.example.pertemuan_14.data.repository

import retrofit2.Retrofit
import com.example.pertemuan_14.data.api.RetrofitClient
import com.example.pertemuan_14.BuildConfig

class NewsRepository {

    suspend fun getNews()=
        RetrofitClient.apiService
            .getTopHeadlines(
                apikey= BuildConfig.NEWS_API_KEY
            )

}