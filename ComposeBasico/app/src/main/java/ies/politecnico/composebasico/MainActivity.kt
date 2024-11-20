package ies.politecnico.composebasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import ies.politecnico.composebasico.ui.theme.ComposeBasicoTheme
import ies.politecnico.composebasico.ui.theme.MercadonaTheme
import ies.politecnico.composebasico.ui.theme.CocaColaTheme
import ies.politecnico.composebasico.ui.theme.DBTheme
import ies.politecnico.composebasico.ui.theme.PepsiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicoTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                    Text(
                        text = name,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun Greetings (modifier: Modifier = Modifier) {
    val baseNames: List<String> = listOf("Mercadona", "Coca Cola", "Pepsi", "Dragon Ball") // Lista de nombres
    val names = List(7) { baseNames[it % baseNames.size] } // Repite los nombres hasta llegar a 8

    Column(modifier = modifier.padding(vertical = 4.dp)) {
        names.forEach { name ->
            when (name) {
                "Mercadona" -> MercadonaTheme { Greeting(name = name) }
                "Coca Cola" -> CocaColaTheme { Greeting(name = name) }
                "Pepsi" -> PepsiTheme { Greeting(name = name) }
                "Dragon Ball" -> DBTheme { Greeting(name = name) }
                else -> ComposeBasicoTheme { Greeting(name = name) }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicoTheme {
        MyApp()
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier) {
            Greetings()
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
    ComposeBasicoTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeBasicoTheme {
        MyApp(Modifier.fillMaxSize())
    }
}