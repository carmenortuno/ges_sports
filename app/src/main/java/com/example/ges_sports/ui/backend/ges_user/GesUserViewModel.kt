package com.example.ges_sports.ui.backend.ges_user

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ges_sports.repository.UserRepository
import com.example.ges_sports.models.User
import kotlinx.coroutines.launch

class GesUserViewModel (val userRepository: UserRepository): ViewModel() {
    var users by mutableStateOf<List<User>>(emptyList())


    var selectedRole by mutableStateOf<String?>(null)


     init {
        viewModelScope.launch {
            users = userRepository.getAllUsers()
        }
     }
    fun onRoleSelected(rol: String?) {
        selectedRole = rol
        viewModelScope.launch {
            users = if (rol == null) {
                userRepository.getAllUsers()
            } else {
                userRepository.getUsersByRole(rol)
            }
        }
    }
}