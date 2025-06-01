package com.example.pizzadelivery

data class AnalyticsEvent(
    val name: String,
    val parameters: Map<String, Any> = emptyMap()
)