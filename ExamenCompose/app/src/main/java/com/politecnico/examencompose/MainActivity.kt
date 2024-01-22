package com.politecnico.examencompose

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.politecnico.examencompose.ui.theme.ExamenComposeTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun columnElement(modifier: Modifier = Modifier) {
    Column() {
        Image(
            modifier = (
                    modifier
                        .size(120.dp)
                        .clip(MaterialTheme.shapes.small)
                    ),
            painter = painterResource(R.drawable.exp4_surf1), contentDescription = null
        )
    }
}

@Composable
fun image(painter: Int, contentDescription: Nothing?) {
    painterResource(id = R.drawable.exp4_surf1)
}

@Composable
fun lazyColumn() {
    LazyColumn { image -> {
        columnElement()
    }
    }
}

@Composable
fun myApp() {
    lazyColumn()
}



@Preview(showBackground = true)
@Composable
fun columnElementPreview() {
    ExamenComposeTheme {
        columnElement()
    }
}