package com.codelab.basiclayouts

import androidx.annotation.StringRes
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("MySootheApp", R.string.app_name)
    object Hotel : Screen("malagaHotel", R.string.malagaHotel)
    object Splash : Screen("SplashScreen", R.string.splash)
}


@Composable
fun AppNavigation(windowSizeClass: WindowSizeClass) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Home.route) { MySootheApp(windowSize = windowSizeClass) }
        composable(Screen.Hotel.route) { malagaHotel(navController) }
        composable(Screen.Splash.route) { SplashScreen(navController) }

        /*  composable("password") { ... }
          composable("registration") { ... }
          */
    }
}