package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(10.dp)) {

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Angka pertama") }
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Angka kedua") }
        )
        OutlinedTextField(
            value = result,
            onValueChange = {},
            label = { Text("Hasil") },
            readOnly = true
        )
        Row {
            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null)
                    (n1 + n2).toString()
                else "Input tidak valid"

            }) { Text("+") }
            Spacer(modifier = Modifier.width(5.dp))


            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null)
                    (n1 - n2).toString()
                else "Input tidak valid"
            }) { Text("-") }
            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null)
                    (n1 * n2).toString()
                else "Input tidak valid"
            }) { Text("*") }
            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null) {
                    if (n2 != 0.0)
                        (n1 / n2).toString()
                    else
                        "Tidak bisa dibagi 0"
                } else {
                    "Input tidak valid"
                }
            }) { Text("/") }
            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = {
                num1 = ""
                num2 = ""
                result = ""
            }) { Text("Clear") }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKalkulator() {
    MyApplicationTheme {
        Kalkulatorapp()
    }
}