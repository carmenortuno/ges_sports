package com.example.ges_sports.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ges_sports.ui.backend.ges_user.GesUserScreen
import com.example.ges_sports.ui.home.HomeScreen
import com.example.ges_sports.ui.login.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "gesuser") {
        composable("login") { LoginScreen(navController) }
        composable("gesuser") { GesUserScreen(navController = navController)}
        composable(
            route = "home/{nombre}",
            arguments = listOf(navArgument("nombre") { type = NavType.StringType })
        )
        {
            backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre")
            HomeScreen(navController, nombre)
        }
    }
}





