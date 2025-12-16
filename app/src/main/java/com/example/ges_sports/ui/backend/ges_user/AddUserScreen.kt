package com.example.ges_sports.ui.backend.ges_user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

import com.example.ges_sports.data.JsonUserRepository
import com.example.ges_sports.models.User
import com.example.ges_sports.models.UserRoles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    // Reutilizas el mismo ViewModel (puedes extraer la factory a una función)
    val viewModel: GesUserViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repo = JsonUserRepository(context)
                return GesUserViewModel(repo) as T
            }
        }
    )

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf("JUGADOR") } // por defecto

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("Nuevo usuario") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,        // fondo
                    titleContentColor = Color.White,      // título
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") }
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") }
            )

            Text("Rol:")

            Column {
                UserRoles.allRoles.forEach { (roleKey, roleLabel) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = rol == roleKey,
                            onClick = { rol = roleKey }
                        )
                        Text(
                            text = roleLabel,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

            }
             Spacer(Modifier.weight(1f))

            Button(
                onClick = {
                    val nuevo = User(
                        id = 0,
                        nombre = nombre,
                        email = email,
                        password = password,
                        rol = rol
                    )
                    viewModel.addUser(nuevo)
                    navController.popBackStack()  // volver a la lista
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
