package org.example.geoblinker.domain.model

data class Device(
    val id: Long,
    val imei: String,
    val name: String,
    val speedText: String,
    val statusText: String,
    val colorHex: Long
)
