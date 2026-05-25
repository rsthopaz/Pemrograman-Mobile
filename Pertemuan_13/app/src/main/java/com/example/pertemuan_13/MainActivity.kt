package com.example.pertemuan_13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan_13.data.AppDatabase
import com.example.pertemuan_13.ui.MainScreen
import com.example.pertemuan_13.viewmodel.StudentViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = AppDatabase
            .getDatabase(applicationContext)
            .siswaDao()

        setContent {

            val viewModel = StudentViewModel(dao)

            MainScreen(viewModel)
        }
    }
}

