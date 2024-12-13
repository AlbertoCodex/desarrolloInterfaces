package ies.politecnico.examencompose.Preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ies.politecnico.examencompose.ContenidoLazy
import ies.politecnico.examencompose.Header
import ies.politecnico.examencompose.HomeApp
import ies.politecnico.examencompose.R
import ies.politecnico.examencompose.ui.theme.ExamenComposeTheme


@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    ExamenComposeTheme {
        Header()
    }
}

@Preview(showBackground = true)
@Composable
fun ContenidoLazyPreview() {
    ExamenComposeTheme {
        ContenidoLazy(R.drawable.golf, R.string.golf, Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun TablaLazyPreview() {
    ExamenComposeTheme {
        TablaLazyPreview()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeAppPreview() {
    ExamenComposeTheme {
        HomeApp()
    }
}