package com.example.simulacro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContadorScreen(viewModel: ContadorViewModel) {
    val contadorData by viewModel.cont.collectAsState()
    Contador(viewModel, contadorData)
}

@Composable
fun ContadorShow(cont: Int, suma: () -> Unit, resta: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Text("$cont", Modifier.padding(end = 8.dp))
        Column {
            Button(onClick = suma, modifier = Modifier, enabled = cont < 20) {
                Text("+")
            }
            Button(onClick = resta, modifier = Modifier, enabled = cont > -20) {
                Text("-")
            }
        }
    }
}

@Composable
fun Contador(viewModel: ContadorViewModel, contadorData: GameUiState) {
    ContadorShow(contadorData.contador, {viewModel.sumar()}, {viewModel.restar()})
}