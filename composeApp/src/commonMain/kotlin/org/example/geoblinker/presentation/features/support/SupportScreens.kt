package org.example.geoblinker.presentation.features.support
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable
fun FrequentQuestionsScreen(onNavigateBack: () -> Unit) {
    Text("Часто задаваемые вопросы (в разработке)")
}

@Composable
fun MakeRequestScreen(onNavigateBack: () -> Unit, onRequestSent: () -> Unit) {
    Text("Создать запрос (в разработке)")
}
