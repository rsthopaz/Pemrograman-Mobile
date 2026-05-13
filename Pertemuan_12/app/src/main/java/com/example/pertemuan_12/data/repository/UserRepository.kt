package com.example.pertemuan_12.data.repository

import com.example.pertemuan_12.data.local.dao.UserDao
import com.example.pertemuan_12.data.local.entity.User

class UserRepository (
    private val dao: UserDao
){
    suspend fun insert(user: User){
        dao.insert(user)
    }

    suspend fun login(username: String, password: String): User? {
        return dao.login(username, password)
    }

}