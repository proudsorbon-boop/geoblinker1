package org.example.geoblinker.presentation.features.common
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) { Text(text) }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    Button(onClick = onClick) { Text("Назад") }
}
