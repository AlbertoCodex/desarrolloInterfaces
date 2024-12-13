package ies.politecnico.examencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ies.politecnico.examencompose.R.drawable.fishing
import ies.politecnico.examencompose.R.drawable.golf
import ies.politecnico.examencompose.R.drawable.restaurant
import ies.politecnico.examencompose.R.drawable.srilanka
import ies.politecnico.examencompose.R.drawable.surf
import ies.politecnico.examencompose.ui.theme.ExamenComposeTheme
import ies.politecnico.examencompose.ui.theme.NaranjoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeApp(modifier: Modifier = Modifier) {
    Column {
        Header()
        TablaLazyColumn()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            // .align(Alignment.CenterHorizontally)
    ) {
        Image(
            painter = painterResource(R.drawable.version1),
            contentDescription = null,
            modifier
                .size(200.dp)
        )
    }
}

@Composable
fun ContenidoLazy(
    @DrawableRes imagen:Int,
    @StringRes texto:Int,
    modifier: Modifier = Modifier) {
    Row(
        Modifier
            .padding(bottom = 10.dp)
        // .align(Alignment.CenterHorizontally)
    ) {
        Image(
            painter = painterResource(imagen),
            contentDescription = null,
            Modifier
                .size(200.dp)
        )
        Text(
            stringResource(texto),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun TablaLazyColumn(
    modifier: Modifier = Modifier) {
    LazyColumn() {
        // Debo ejecutar la funcion ContenidoLazy() mediante una funcion lambda
        // a la cual añadirle el mapa de la variable columnData
        // pero no recuerdo como hacerlo.
        columnData.forEach() {
           // NaranjoTheme { ContenidoLazy() }
        }
    }
}

// Data
val columnData = listOf(
    srilanka to R.string.srilanka,
    golf to R.string.golf,
    fishing to R.string.pesca,
    restaurant to R.string.restaurantes,
    surf to R.string.surfeando
).map { Pair(it.first, it.second) }