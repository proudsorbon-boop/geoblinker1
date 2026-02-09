package org.example.geoblinker.core.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val result: Int? = null,
    val sid: String? = null,
    val error: String? = null,
    val token: String? = null,
    val user_id: String? = null
)

@Serializable
data class GpsAccountResponse(
    val success: Boolean,
    val data: String? = null, // Сюда прилетит SID для gps666
    val msg: String? = null
)
