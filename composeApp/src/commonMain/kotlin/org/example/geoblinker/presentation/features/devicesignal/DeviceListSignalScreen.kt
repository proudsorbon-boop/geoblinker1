package org.example.geoblinker.presentation.features.devicesignal


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun DeviceListSignalScreen(
    viewModel: DeviceListSignalViewModel,
    toBack: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Экран сигналов: ${state.deviceName}")
        // Сюда потом вернем верстку, сейчас главное запустить
        Button(onClick = toBack) { Text("Назад") }
    }
}