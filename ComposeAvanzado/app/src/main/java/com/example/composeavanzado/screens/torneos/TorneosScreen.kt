package com.example.composeavanzado.screens.torneos




import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.composeavanzado.R
import com.example.composeavanzado.data.TorneoData
import com.example.composeavanzado.screens.home.SootheBottomNavigation
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun TorneosScreen(navController: NavController, viewModel: TorneosViewModel, db:FirebaseFirestore) {
    val torneos by viewModel.torneos.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(true)

    Scaffold(
        bottomBar = { SootheBottomNavigation(modifier = Modifier, navController = navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (isLoading) {
                if (torneos.isEmpty()) {
                    viewModel.cargarTorneosConFiltros(db)
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            } else {
                // Filtros fijos arriba
                FiltrosSection { modalidad, pais ->
                    viewModel.cargarTorneosConFiltros(db, modalidad, pais)
                }
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f) // Hace que el LazyColumn use el espacio sobrante y permita el scroll
                ) {
                    items(torneos) { torneo ->
                        TorneoItem(torneo = torneo)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun TorneoItem(torneo: TorneoData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Imagen del torneo (usar un mapa)
            Image(
                painter = painterResource(id = getModalidadResource(torneo.modalidad)),
                contentDescription = "Imagen del torneo",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = "#${torneo.numero} ${torneo.nombre}", style = MaterialTheme.typography.titleMedium)
                Text(text = torneo.modalidad, style = MaterialTheme.typography.bodyMedium)
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(text = "Jugadores: ${torneo.numJugadores}", style = MaterialTheme.typography.bodyMedium)
                Image(
                    painter = rememberAsyncImagePainter(torneo.pais),
                    contentDescription = "Bandera",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun FiltrosSection(onFilterChange: (String?, String?) -> Unit) {
    val modalidades = listOf("omaha", "texashe", "draw", "stud", "horse")
    val paises = listOf("España", "Francia", "Alemania")

    var modalidad by remember { mutableStateOf<String?>(null) }
    var pais by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DropdownMenuFiltro("Modalidad", modalidades, modalidad) { modalidad = it }
                DropdownMenuFiltro("País", paises, pais) { pais = it }
            }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onFilterChange(modalidad, pais) }) {
            Text("Aplicar Filtros")
        }
    }
}

@Composable
fun DropdownMenuFiltro(label: String, opciones: List<String>, seleccion: String?, onSeleccionChange: (String?) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(seleccion ?: label)
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            opciones.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(opcion) },
                    onClick = {
                        onSeleccionChange(opcion)
                        expanded = false
                    }
                )
            }
            DropdownMenuItem(
                text = { Text("Limpiar") },
                onClick = {
                    onSeleccionChange(null)
                    expanded = false
                }
            )
        }
    }
}

// Función auxiliar para mapear el nombre de la modalidad al recurso
fun getModalidadResource(modalidad: String): Int {
    return when (modalidad) {
        "omaha" -> R.drawable.modalidad_omaha
        "texashe" -> R.drawable.modalidad_texashe
        "draw" -> R.drawable.modalidad_draw
        "stud" -> R.drawable.modalidad_stud
        "horse" -> R.drawable.modalidad_horse
        else -> R.drawable.login_icon
    }
}