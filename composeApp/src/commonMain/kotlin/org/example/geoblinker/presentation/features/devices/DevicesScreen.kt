package org.example.geoblinker.presentation.features.devices
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import cafe.adriel.voyager.core.screen.Screen
//import cafe.adriel.voyager.koin.koinScreenModel
//import cafe.adriel.voyager.navigator.LocalNavigator
//import cafe.adriel.voyager.navigator.currentOrThrow
//import org.example.geoblinker.presentation.features.map.MapScreen
//
//class DevicesScreen : Screen {
//    @Composable
//    override fun Content() {
//        val viewModel: DevicesViewModel = koinScreenModel()
//        val state by viewModel.uiState.collectAsState()
//        val navigator = LocalNavigator.currentOrThrow
//
//        LaunchedEffect(Unit) {
//            viewModel.refresh()
//        }
//
//        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//            Text("Мониторинг", style = MaterialTheme.typography.headlineMedium)
//            Spacer(Modifier.height(16.dp))
//
//            if (state.isLoading) {
//                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
//            }
//
//            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//                items(state.devices) { device ->
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                // Переход на карту при клике
//                                navigator.push(MapScreen(device.imei, device.name))
//                            }
//                    ) {
//                        Row(
//                            modifier = Modifier.padding(16.dp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .size(12.dp)
//                                    .background(
//                                        if (device.online) Color(0xFF4CAF50) else Color.Gray,
//                                        CircleShape
//                                    )
//                            )
//                            Spacer(Modifier.width(16.dp))
//                            Column {
//                                Text(device.name, style = MaterialTheme.typography.titleMedium)
//                                Text("IMEI: ${device.imei}", style = MaterialTheme.typography.bodySmall)
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
