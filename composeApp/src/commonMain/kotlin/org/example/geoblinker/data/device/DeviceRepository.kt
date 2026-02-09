package org.example.geoblinker.data.device

import io.ktor.client.*
import kotlinx.serialization.Serializable
import org.example.geoblinker.core.settings.SessionManager

@Serializable
data class DeviceResponse(val imei: String, val name: String, val online: Boolean)

@Serializable
data class DeviceLocationResponse(val lat: Double, val lng: Double, val speed: Double)

interface DeviceRepository {
    suspend fun getDeviceList(): List<DeviceResponse>
    suspend fun getDeviceLocation(imei: String): DeviceLocationResponse
}

class DeviceRepositoryImpl(
    private val client: HttpClient,
    private val sessionManager: SessionManager
) : DeviceRepository {
    
    override suspend fun getDeviceList(): List<DeviceResponse> {
        return listOf(
            DeviceResponse("111", "Грузовик Вольво", true),
            DeviceResponse("222", "Экскаватор CAT", true),
            DeviceResponse("333", "Бетономешалка", false)
        )
    }

    override suspend fun getDeviceLocation(imei: String): DeviceLocationResponse {
        // Заглушка для будущих карт
        return DeviceLocationResponse(55.7558, 37.6173, 0.0)
    }
}
