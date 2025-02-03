package com.example.composeavanzado.navigation

sealed class AppScreens(val route:String) {
    object Main:AppScreens("main")
    object Settings:AppScreens("settings")
    object Login:AppScreens("login")
    object Register:AppScreens("register")
    object Splash:AppScreens("splash")
}