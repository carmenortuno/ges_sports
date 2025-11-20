package com.example.ges_sports.data

import com.example.ges_sports.models.User
import com.example.ges_sports.repository.UserRepository

class JsonUserRepository: UserRepository {
    override suspend fun getAllUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUsersByRole(rol: String): List<User> {
        TODO("Not yet implemented")
    }
}