package org.example.geoblinker.presentation.features.settings
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable fun SettingsScreen(onNavigateBack: () -> Unit) { Text("Настройки") }
@Composable fun PhoneSettingsScreen(onNavigateBack: () -> Unit) { Text("Телефон") }
@Composable fun NameSettingsScreen(onNavigateBack: () -> Unit) { Text("Имя") }
@Composable fun EmailSettingsScreen(onNavigateBack: () -> Unit) { Text("Email") }
@Composable fun ConfirmationCodeSettingsScreen(onNavigateBack: () -> Unit) { Text("Код") }
@Composable fun DeleteAccountSettingsScreen(onNavigateBack: () -> Unit) { Text("Удаление") }
@Composable fun NotificationSettingsScreen(onNavigateBack: () -> Unit) { Text("Уведомления") }
@Composable fun UnitDistanceSettingsScreen(onNavigateBack: () -> Unit) { Text("Дистанция") }
