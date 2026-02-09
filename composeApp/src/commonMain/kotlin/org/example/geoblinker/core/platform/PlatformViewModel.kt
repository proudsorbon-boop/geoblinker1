package org.example.geoblinker.core.platform

import kotlinx.coroutines.CoroutineScope

expect abstract class PlatformViewModel() {
    val coroutineScope: CoroutineScope
}
