package com.example.pizzadelivery.services

import android.util.Log
import com.example.pizzadelivery.AnalyticsEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.*

data class TrackedEvent(
    val id: String = UUID.randomUUID().toString(),
    val timestamp: Date = Date(),
    val name: String,
    val parameters: Map<String, Any>
) {
    val formattedTime: String
        get() {
            val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            return formatter.format(timestamp)
        }

    val parametersString: String
        get() {
            if (parameters.isEmpty()) return "{}"
            val pairs = parameters.map { "\"${it.key}\": \"${it.value}\"" }
            return "{ ${pairs.joinToString(", ")} }"
        }
}

object AnalyticsService {
    private val _eventHistory = MutableStateFlow<List<TrackedEvent>>(emptyList())
    val eventHistory: StateFlow<List<TrackedEvent>> = _eventHistory.asStateFlow()

    fun track(event: AnalyticsEvent) {
        val trackedEvent = TrackedEvent(
            timestamp = Date(),
            name = event.name,
            parameters = event.parameters
        )
        _eventHistory.value = _eventHistory.value + trackedEvent
        Log.d("Analytics", "📊 ${event.name}: ${event.parameters}")
    }

    fun clearHistory() {
        _eventHistory.value = emptyList()
    }
}
