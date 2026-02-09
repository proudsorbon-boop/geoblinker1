package org.example.geoblinker.core.math

object LegacyConverter {
    fun speedToUiString(speedKmh: Double, isMetric: Boolean): String = 
        if (isMetric) "${speedKmh.toInt()} км/ч" else "${(speedKmh * 0.621371).toInt()} mph"
    
    fun microDegreesToString(microDegrees: Long): String = 
        (microDegrees / 1_000_000.0).toString()

    fun levelToColorHex(level: Long): Long = when {
        level > 70 -> 0xFF43A047 // Зеленый
        level > 30 -> 0xFFFB8C00 // Оранжевый
        else -> 0xFFE53935       // Красный
    }
}
