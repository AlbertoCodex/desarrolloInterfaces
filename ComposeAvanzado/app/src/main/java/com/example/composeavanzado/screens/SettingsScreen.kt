package com.example.composeavanzado.screens




import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeavanzado.R
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.composeavanzado.ui.theme.ComposeAvanzadoTheme


@Composable
fun SettingsApp(windowSize: WindowSizeClass, navController: NavController) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            SettingsPortrait(navController)
        }
        WindowWidthSizeClass.Expanded -> {
            SettingsLandscape()
        }
        else -> SettingsPortrait(navController) // Default
    }
}

@Composable
fun SettingsHome(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.utilidad_escala),
            contentDescription = null)
    }
}

@Composable
fun SettingsPortrait(navController: NavController) {
    ComposeAvanzadoTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation(modifier = Modifier, navController) }
        ) { padding ->
            SettingsHome(Modifier.padding(padding))
        }
    }
}

@Composable
fun SettingsLandscape() {
    ComposeAvanzadoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                SettingsHome()
            }
        }
    }
}






