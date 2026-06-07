package com.example.pertemuan_14.ui.state

import com.example.pertemuan_14.data.model.Article

sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(
        val articles: List<Article>
    ) : NewsUiState()
    data class Error(
        val message: String
    ) : NewsUiState()
}