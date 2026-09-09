package es.nazra.fotocoach.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF1B5D57),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD4ECE8),
    onPrimaryContainer = Color(0xFF0A3430),
    secondary = Color(0xFF8A5B18),
    secondaryContainer = Color(0xFFFCE7B4),
    background = Color(0xFFF8F7F3),
    surface = Color(0xFFFFFBF5),
    surfaceVariant = Color(0xFFECEAE3),
    onBackground = Color(0xFF20231F),
    onSurface = Color(0xFF20231F)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA7D8D1),
    onPrimary = Color(0xFF073B36),
    primaryContainer = Color(0xFF164E49),
    secondary = Color(0xFFF0C66F),
    background = Color(0xFF111411),
    surface = Color(0xFF181C18),
    surfaceVariant = Color(0xFF2A2F2B)
)

@Composable
fun FotoCoachTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = MaterialTheme.typography,
        content = content
    )
}
