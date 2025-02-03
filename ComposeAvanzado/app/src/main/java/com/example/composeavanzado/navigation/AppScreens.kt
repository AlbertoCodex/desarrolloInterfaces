package com.example.composeavanzado.navigation

sealed class AppScreens(val route:String) {
    object Main:AppScreens("main")
    object Torneos:AppScreens("torneos")
    object Login:AppScreens("login")
    object Register:AppScreens("register")
    object Splash:AppScreens("splash")
    object Profile:AppScreens("profile")
}