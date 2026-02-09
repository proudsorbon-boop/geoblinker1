package org.example.geoblinker.core.settings

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SessionManager {
    private var _sid: String? = null
    private val mutex = Mutex()

    suspend fun saveSession(newSid: String) = mutex.withLock {
        _sid = newSid
    }

    suspend fun getSid(): String? = mutex.withLock { 
        _sid 
    }

    suspend fun clear() = mutex.withLock { 
        _sid = null 
    }
}
