package com.example.pertemuan_13.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormInput(
    nama: String,
    email: String,
    onNamaChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onTambahClick: () -> Unit
){
    Column() {
        TextField(
            value = nama,
            onValueChange = onNamaChange,
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onTambahClick,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Tambah Siswa")
        }
        }

    }

}