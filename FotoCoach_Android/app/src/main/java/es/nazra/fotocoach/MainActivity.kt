package es.nazra.fotocoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import es.nazra.fotocoach.ui.FotoCoachApp
import es.nazra.fotocoach.ui.theme.FotoCoachTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FotoCoachTheme {
                FotoCoachApp()
            }
        }
    }
}
