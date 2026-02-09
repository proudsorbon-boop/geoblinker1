package org.example.geoblinker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Signal(
    val id: Long = 0,
    val deviceId: String,
    val name: String,
    val dateTime: Long,
    val isSeen: Long = 0
)