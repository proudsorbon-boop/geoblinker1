package org.example.geoblinker.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.example.geoblinker.core.settings.SessionManager
import org.example.geoblinker.domain.repository.AuthRepository
import org.example.geoblinker.data.device.DeviceRepository
import org.example.geoblinker.data.device.DeviceRepositoryImpl
import org.example.geoblinker.presentation.features.auth.AuthViewModel
import org.example.geoblinker.presentation.features.devices.DevicesViewModel
// Импорты нашего экрана
import org.example.geoblinker.presentation.features.devicesignal.DeviceListSignalViewModel
import org.example.geoblinker.db.AppDatabase
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true; isLenient = true })
            }
            install(Logging) { level = LogLevel.ALL }
        }
    }
    single { SessionManager() }
}

val repositoryModule = module {
    single { AuthRepository(get()) }
    single<DeviceRepository> { DeviceRepositoryImpl(get(), get()) }
}

val databaseModule = module {
    // Получаем queries из базы (Базу должен создать платформенный модуль)
    single { get<AppDatabase>().signalQueries }
}

val screenModelModule = module {
    factory { AuthViewModel(get(), get()) }
    factory { DevicesViewModel(get()) }

    // НАША VIEW MODEL
    factory {
        DeviceListSignalViewModel(
            signalQueries = get(),
            deviceId = "test_device_1",
            coroutineScope = CoroutineScope(Dispatchers.Main)
        )
    }
}

val allModules = listOf(networkModule, repositoryModule, screenModelModule, databaseModule)