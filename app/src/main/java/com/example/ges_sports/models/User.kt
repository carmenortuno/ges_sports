package com.example.ges_sports.models

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val id: Int,
    val nombre: String,
    val email: String,
    val password: String,
    val rol: String
)