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
fun HelloWorldApp(windowSize: WindowSizeClass, navController: NavController) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            HelloWorldPortrait(navController)
        }
        WindowWidthSizeClass.Expanded -> {
            HellowWorldLandscape()
        }
        else -> HelloWorldPortrait(navController) // Default
    }
}

@Composable
fun HelloWorldHome(modifier: Modifier = Modifier) {
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
fun HelloWorldPortrait(navController: NavController) {
    ComposeAvanzadoTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation(modifier = Modifier, navController) }
        ) { padding ->
            HelloWorldHome(Modifier.padding(padding))
        }
    }
}

@Composable
fun HellowWorldLandscape() {
    ComposeAvanzadoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                HelloWorldHome()
            }
        }
    }
}






