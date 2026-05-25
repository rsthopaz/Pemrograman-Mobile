package com.example.pertemuan_13.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan_13.data.Siswa
import com.example.pertemuan_13.data.SiswaDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.stateIn

class StudentViewModel(
    private val dao: SiswaDao
) : ViewModel() {

    val siswaList = dao.getAllSiswa().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun tambahSiswa(nama: String, email: String){
        viewModelScope.launch {
            dao.insert(Siswa(nama = nama, email = email))
        }
    }

    fun hapusSiswa(siswa: Siswa){
        viewModelScope.launch {
            dao.delete(siswa)
        }
    }

    fun updateSiswa(siswa: Siswa){
        viewModelScope.launch {
            dao.update(siswa)
        }
    }


}