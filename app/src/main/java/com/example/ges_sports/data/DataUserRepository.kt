package com.example.ges_sports.data

import com.example.ges_sports.models.User
import com.example.ges_sports.repository.UserRepository

class DataUserRepository: UserRepository {

        private val users = listOf(
            User(
                id = 1,
                nombre = "Ana Pérez",
                email = "ana.admin@club.es",
                password = "1234",
                rol = "ADMIN_DEPORTIVO"
            ),
            User(
                id = 2,
                nombre = "Pedro Caselles",
                email = "pedro.entrenador@club.es",
                password = "1234",
                rol ="ENTRENADOR"
            ),
            User(
                id = 3,
                nombre = "Pepa Ferrández",
                email = "laura.jugadora@club.es",
                password = "1234",
                rol = "JUGADOR"
            ),
            User(
                id = 4,
                nombre = "Pablo Teruel",
                email = "luis.arbitro@club.es",
                password = "1234",
                rol = "ARBITRO"
            ),
            User(
                id = 5,
                nombre = "María Belmonte",
                email = "maria.jugadora@club.es",
                password = "1234",
                rol = "JUGADOR"
            )
        )

        override suspend fun getAllUsers(): List<User> {
            return users
        }

        override suspend fun getUsersByRole(rol: String): List<User> =
            users.filter { it.rol == rol }
}


