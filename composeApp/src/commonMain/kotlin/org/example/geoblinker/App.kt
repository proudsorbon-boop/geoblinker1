package org.example.geoblinker

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject
import org.example.geoblinker.presentation.features.devicesignal.DeviceListSignalScreen
import org.example.geoblinker.presentation.features.devicesignal.DeviceListSignalViewModel


@Composable
fun App() {
    MaterialTheme {
        // Запускаем сразу наш экран
        Navigator(TestSignalScreen())
    }
}

class TestSignalScreen : Screen {
    @Composable
    override fun Content() {
        // Koin сам найдет и создаст ViewModel
        val viewModel = koinInject<DeviceListSignalViewModel>()

        DeviceListSignalScreen(
            viewModel = viewModel,
            toBack = { /* Ничего не делаем */ }
        )
    }
}