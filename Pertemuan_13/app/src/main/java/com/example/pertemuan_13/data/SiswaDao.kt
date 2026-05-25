package com.example.pertemuan_13.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SiswaDao {
    @Insert
    suspend fun insert(siswa: Siswa)

    @Update
    suspend fun update(siswa: Siswa)

    @Delete
    suspend fun delete(siswa: Siswa)

    @Query("SELECT * FROM siswa ORDER BY id DESC")
    fun getAllSiswa(): Flow<List<Siswa>>


}