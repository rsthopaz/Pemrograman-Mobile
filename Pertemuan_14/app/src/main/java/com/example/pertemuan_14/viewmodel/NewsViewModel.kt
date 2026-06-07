package com.example.pertemuan_14.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan_14.data.repository.NewsRepository
import com.example.pertemuan_14.ui.state.NewsUiState

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    private val _uistate =
        MutableStateFlow<NewsUiState>(
            NewsUiState.Loading
        )

    val uistate = _uistate.asStateFlow()

    init {
        loadNews()
    }

    fun loadNews(){

        viewModelScope.launch {

            try {
                _uistate.value = NewsUiState.Loading

                val response = repository.getNews()

                _uistate.value = NewsUiState.Success(
                    response.articles
                )
            } catch (e: Exception){

                _uistate.value = NewsUiState.Error(
                    e.message ?: "Unknown Error"
                )
            }
        }

    }

}