package ies.politecnico.composebasico.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ies.politecnico.composebasico.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// Tipografía para Mercadona
val MercadonaTypography = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
)

// Tipografía para Coca Cola
val CocaColaFontFamily = FontFamily(
    Font(R.font.coca_cola_font, FontWeight.Normal)
)
val CocaColaTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = CocaColaFontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold
    )
)

// Tipografía para Pepsi
val PepsiFontFamily = FontFamily(
    Font(R.font.pepsi_font, FontWeight.Normal)
)
val PepsiTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = PepsiFontFamily,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    )
)

// Tipografía para DB
val DBFontFamily = FontFamily(
    Font(R.font.dragon_ball_font, FontWeight.Normal)
)
val DBTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = DBFontFamily,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    )
)