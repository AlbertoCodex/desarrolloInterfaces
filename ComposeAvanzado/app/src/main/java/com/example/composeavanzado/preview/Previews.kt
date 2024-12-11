package com.example.composeavanzado.preview

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeavanzado.AlignYourBodyElement
import com.example.composeavanzado.AlignYourBodyRow
import com.example.composeavanzado.FavoriteCollectionCard
import com.example.composeavanzado.FavoriteCollectionsGrid
import com.example.composeavanzado.HomeScreen
import com.example.composeavanzado.HomeSection
import com.example.composeavanzado.PokerApp
import com.example.composeavanzado.R
import com.example.composeavanzado.SearchBar
import com.example.composeavanzado.ui.theme.ComposeAvanzadoTheme

class Previews {

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun SearchBarPreview() {
        ComposeAvanzadoTheme { SearchBar(Modifier.padding(8.dp)) }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyElementPreview() {
        ComposeAvanzadoTheme {
            AlignYourBodyElement(
                text = R.string.omaha,
                drawable = R.drawable.omaha,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionCardPreview() {
        ComposeAvanzadoTheme {
            FavoriteCollectionCard(
                text = R.string.mejores_manos,
                drawable = R.drawable.omaha,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun FavoriteCollectionsGridPreview() {
        ComposeAvanzadoTheme { FavoriteCollectionsGrid() }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun AlignYourBodyRowPreview() {
        ComposeAvanzadoTheme { AlignYourBodyRow() }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
    @Composable
    fun HomeSectionPreview() {
        ComposeAvanzadoTheme {
            HomeSection(R.string.omaha) {
                AlignYourBodyRow()
            }
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
    @Composable
    fun ScreenContentPreview() {
        ComposeAvanzadoTheme { HomeScreen() }
    }
}