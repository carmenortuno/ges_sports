package com.example.ges_sports.repository

import com.example.ges_sports.models.User

interface UserRepository {
    suspend fun getAllUsers(): List<User>
    suspend fun getUsersByRole(rol: String): List<User>
}