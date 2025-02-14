package com.example.simulacro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.simulacro.ui.theme.SimulacroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var viewmodel = ContadorViewModel()
            SimulacroTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ContadorScreen(viewmodel)
                }
            }
        }
    }
}