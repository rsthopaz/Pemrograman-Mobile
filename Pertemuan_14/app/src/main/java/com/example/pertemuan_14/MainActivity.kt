    package com.example.pertemuan_14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.pertemuan_14.navigation.AppNavGraph

    class MainActivity : ComponentActivity() {
        override fun onCreate(
            savedInstanceState: Bundle?
        ) {
            super.onCreate(savedInstanceState)
            setContent {
                MaterialTheme {
                    AppNavGraph()
                }
            }
        }
    }