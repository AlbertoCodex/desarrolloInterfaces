package com.example.composeavanzado.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeavanzado.screens.LoginScreen
import com.example.composeavanzado.screens.LoginViewModel
import com.example.composeavanzado.screens.SettingsApp
import com.example.composeavanzado.screens.PokerApp

@Composable
fun AppNavigation(windowSizeClass: WindowSizeClass) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Login.route) {
        composable(route = AppScreens.Main.route) {
            PokerApp(windowSizeClass, navController)
        }
        composable(route = AppScreens.Settings.route) {
            SettingsApp(windowSizeClass, navController)
        }
        composable(route = AppScreens.Login.route) {
            LoginScreen(navController, LoginViewModel())
        }
    }
}
