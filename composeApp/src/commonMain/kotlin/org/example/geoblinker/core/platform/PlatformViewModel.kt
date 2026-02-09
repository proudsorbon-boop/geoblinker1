package org.example.geoblinker.core.platform
import kotlinx.coroutines.CoroutineScope

expect abstract class PlatformViewModel() {
    val coroutineScope: CoroutineScope
    protected open fun onCleared() // Добавим этот метод, чтобы можно было переопределять в Android/iOS
}