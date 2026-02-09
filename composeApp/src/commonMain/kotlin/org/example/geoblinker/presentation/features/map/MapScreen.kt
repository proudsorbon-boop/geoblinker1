package org.example.geoblinker.presentation.features.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class MapScreen(private val imei: String, private val name: String) : Screen {
    @Composable
    override fun Content() {
        // Пока просто заглушка, чтобы проверить, что навигация работает
        // На следующем шаге зальем сюда реальную карту
        androidx.compose.material3.Text("Тут будет карта для $name (IMEI: $imei)")
    }
}
