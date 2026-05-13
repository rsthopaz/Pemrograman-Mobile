package com.example.pertemuan_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan_12.data.local.database.AppDatabase
import com.example.pertemuan_12.data.repository.UserRepository
import com.example.pertemuan_12.ui.theme.Pertemuan_12Theme
//import com.example.pertemuan_12.ui.screen.LoginScreen
import com.example.pertemuan_12.ui.screen.LoginScreen
import com.example.pertemuan_12.viewmodel.LoginViewModel
import com.example.pertemuan_12.viewmodel.LoginViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database =
            AppDatabase.getDatabase(this)
        val repository =
            UserRepository(
                database.userDao()
            )
        val factory = LoginViewModelFactory(repository)
        setContent {
            val viewModel: LoginViewModel = viewModel(factory = factory)
            androidx.compose.runtime.LaunchedEffect(Unit) {
                viewModel.insertDummyUser()
            }
            LoginScreen(viewModel)
        }
    }
}