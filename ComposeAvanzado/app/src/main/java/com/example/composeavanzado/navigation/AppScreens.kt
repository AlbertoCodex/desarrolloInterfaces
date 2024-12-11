package com.example.composeavanzado.navigation

sealed class AppScreens(val route:String) {
    object Main:AppScreens("main")
    object Segunda:AppScreens("segunda")
}