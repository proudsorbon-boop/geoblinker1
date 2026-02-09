package org.example.geoblinker.presentation.features.devicesignal

import org.example.geoblinker.domain.model.Signal
import org.example.geoblinker.domain.model.Device

data class DeviceListSignalState(
    val deviceName: String = "Устройство",
    val signals: List<Signal> = emptyList(),
    val currentSortKey: Int = 0,
    val isLoading: Boolean = true
)

sealed class DeviceListSignalEvent {
    data object LoadSignals : DeviceListSignalEvent()
    data class SortBy(val sortKey: Int) : DeviceListSignalEvent()
    data class SignalSeen(val signal: Signal) : DeviceListSignalEvent()
}