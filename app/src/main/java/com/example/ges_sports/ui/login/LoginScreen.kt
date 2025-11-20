package com.example.ges_sports.ui.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.ges_sports.domain.LogicLogin
import com.example.ges_sports.ui.theme.AppGradient
import com.example.ges_sports.ui.theme.PrimaryTurquoise


@Composable
fun LoginScreen(navController: NavController) {
    val logic = remember { LogicLogin() }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppGradient)
            .padding(24.dp)
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Inicio de sesión", style = MaterialTheme.typography.headlineSmall)

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    try {
                        val user = logic.comprobarLogin(email, password)
                        navController.navigate("home/${user.nombre}")
                    } catch (e: IllegalArgumentException) {
                        errorMessage = e.message
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,                // Fondo del botón
                    contentColor = PrimaryTurquoise              // Color del texto o icono
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Iniciar sesión")
            }
            if (errorMessage != null) {
                Spacer(Modifier.height(16.dp))
                Text(
                    text = errorMessage!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

