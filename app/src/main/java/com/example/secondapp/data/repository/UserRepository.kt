package com.example.secondapp.data.repository

import com.example.secondapp.data.local.DatabaseDao
import com.example.secondapp.data.local.models.toData
import com.example.secondapp.data.local.models.toEntity
import com.example.secondapp.domain.entity.User

class UserRepository(
    private val databaseDAO: DatabaseDao) {
    suspend fun createUser(user: User){
        databaseDAO.insert(user.toData())
    }

    fun getUser(email: String): User? {
        val userLocal = databaseDAO.findByName(email)
        return userLocal?.toEntity()
    }

}