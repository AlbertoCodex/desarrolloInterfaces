package com.example.composeavanzado.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeavanzado.screens.login.LoginScreen
import com.example.composeavanzado.screens.login.LoginViewModel
import com.example.composeavanzado.screens.home.PokerApp
import com.example.composeavanzado.screens.torneos.TorneosScreen
import com.example.composeavanzado.screens.splash.SplashScreen
import com.example.composeavanzado.screens.login.RegisterScreen
import com.example.composeavanzado.screens.login.RegisterViewModel
import com.example.composeavanzado.screens.perfil.ProfileScreen
import com.example.composeavanzado.screens.perfil.ProfileViewModel
import com.example.composeavanzado.screens.torneos.TorneosViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AppNavigation(windowSizeClass: WindowSizeClass, auth: FirebaseAuth, db:FirebaseFirestore) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Splash.route) {
        composable(route = AppScreens.Main.route) {
            PokerApp(windowSizeClass, navController)
        }
        composable(route = "torneos/{modalidad}") { backStackEntry ->
            val modalidad = backStackEntry.arguments?.getString("modalidad")
            TorneosScreen(navController, TorneosViewModel(), db, modalidad)
        }
        composable(route = AppScreens.Login.route) {
            LoginScreen(navController, LoginViewModel(), auth)
        }
        composable(route = AppScreens.Register.route) {
            RegisterScreen(navController, RegisterViewModel(), auth, db)
        }
        composable(route = AppScreens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.Profile.route) {
            ProfileScreen(navController, ProfileViewModel(), db, auth)
        }
    }
}