package com.example.pertemuan_14.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan_14.ui.screens.HomeScreen
import com.example.pertemuan_14.viewmodel.NewsViewModel

@Composable
fun AppNavGraph() {
    val navController =
        rememberNavController()
    val viewModel =
        viewModel<NewsViewModel>()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                viewModel = viewModel
            ) { article ->
            }
        }
    }
}