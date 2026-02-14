package org.example.geoblinker

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.geoblinker.presentation.features.auth.LoginScreen

@Composable
fun App() {
    MaterialTheme {
        // Теперь стартуем с экрана авторизации
        Navigator(LoginScreen())
    }
}