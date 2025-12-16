package com.example.ges_sports.ui.backend.ges_user

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ges_sports.data.JsonUserRepository

/*
Una factoría de ViewModel es una clase cuya única misión es saber cómo
crear (y con qué dependencias) un ViewModel.
se utiliza cuando tu ViewModel necesita parámetros en el constructor (por ejemplo,
un repositorio, un Context, etc.) y ya no puedes usar el constructor vacío típico.
*/

class GesUserViewModelFactory(
    private val appContext: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repo = JsonUserRepository(appContext)  // se crea tu repo real
        return GesUserViewModel(repo) as T  //se crea el ViewModel
    }
}