package org.example.geoblinker.presentation.features.devicesignal

import org.example.geoblinker.domain.model.Signal
import org.example.geoblinker.db.SignalQueries
import org.example.geoblinker.core.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DeviceListSignalViewModel(
    private val signalQueries: SignalQueries,
    private val deviceId: String,
    coroutineScope: CoroutineScope
) : BaseViewModel<DeviceListSignalState, DeviceListSignalEvent>(DeviceListSignalState(), coroutineScope) {

    init {
        loadSignals()
    }

    override fun onEvent(event: DeviceListSignalEvent) {
        when (event) {
            is DeviceListSignalEvent.LoadSignals -> loadSignals()
            is DeviceListSignalEvent.SortBy -> sortSignals(event.sortKey)
            is DeviceListSignalEvent.SignalSeen -> markAsSeen(event.signal)
        }
    }

    private fun loadSignals() {
        coroutineScope.launch {
            val dbSignals = signalQueries.getAllDeviceSignals(deviceId).executeAsList()
            val domainSignals = dbSignals.map {
                Signal(
                    id = it.id,
                    deviceId = it.deviceId,
                    name = it.name,
                    dateTime = it.dateTime,
                    isSeen = it.isSeen
                )
            }
            updateState { it.copy(signals = domainSignals, isLoading = false) }
        }
    }

    private fun sortSignals(sortKey: Int) {
        val sorted = if (sortKey == 1) state.value.signals.sortedBy { it.name }
        else state.value.signals.sortedByDescending { it.dateTime }
        updateState { it.copy(signals = sorted, currentSortKey = sortKey) }
    }

    private fun markAsSeen(signal: Signal) {
        coroutineScope.launch {
            signalQueries.updateSignalSeen(1L, signal.id)
        }
    }
}