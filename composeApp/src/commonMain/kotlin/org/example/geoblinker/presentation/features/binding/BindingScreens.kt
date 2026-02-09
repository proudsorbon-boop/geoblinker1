package org.example.geoblinker.presentation.features.binding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable fun BindingOneScreen(onNavigateBack: () -> Unit, onNext: () -> Unit) { Text("Заглушка Привязка 1") }
@Composable fun BindingTwoScreen(onNavigateBack: () -> Unit, onNext: () -> Unit) { Text("Заглушка Привязка 2") }
@Composable fun BindingThreeScreen(onNavigateBack: () -> Unit, onFinish: () -> Unit) { Text("Заглушка Привязка 3") }
