package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kalkulatorapp()
        }
    }
}

@Composable
fun Kalkulatorapp(){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)){
        OutlinedTextField(
            value = num1,
            onValueChange = {num1 = it},
            label = {Text("Angka pertama")}
        )

        OutlinedTextField(
            value = operator,
            onValueChange = {operator = it},
            label = { Text("Operator (+, -, *, /)")}
        )

        OutlinedTextField(
            value = num2,
            onValueChange = {num2 = it},
            label = {Text("Angka kedua")}
        )

        Button(onClick = {
            val n1 = num1.toDoubleOrNull()
            val n2 = num2.toDoubleOrNull()

            result = if (n1 != null && n2 != null){
                when (operator){
                    "+" -> (n1 + n2).toString()
                    "-" -> (n1 - n2).toString()
                    "*" -> (n1 * n2).toString()
                    "/" -> if (n2 != 0.0) (n1 / n2).toString() else "Tidak bisa dibagi 0"
                    else -> "Operator salah"
                }
            } else {
                "Input tidak valid"
            }
        }) {
            Text("Hitung")
        }
        Text("Hasil: $result")
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewKalkulator() {
    MyApplicationTheme {
        Kalkulatorapp()
    }
}