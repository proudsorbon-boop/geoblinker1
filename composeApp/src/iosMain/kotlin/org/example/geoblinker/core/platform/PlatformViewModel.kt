package org.example.geoblinker.core.platform

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class PlatformViewModel actual constructor() {
    actual val coroutineScope: CoroutineScope = MainScope()

    actual protected open fun onCleared() {
        coroutineScope.cancel()
    }
}