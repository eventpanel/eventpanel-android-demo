package com.example.pizzadelivery.theme

import androidx.compose.ui.graphics.Color

// Background colors
val EpBackground = Color(0xFF0a0a0f)
val EpBackgroundSecondary = Color(0xFF12121a)
val EpCard = Color(0xFF1a1a25)
val EpCardHover = Color(0xFF22222f)

// Border colors
val EpBorder = Color(0xFF2a2a3a)
val EpBorderActive = Color(0xFF4a4a6a)

// Text colors
val EpTextPrimary = Color(0xFFf0f0f5)
val EpTextSecondary = Color(0xFF8888a0)
val EpTextMuted = Color(0xFF5a5a70)

// Accent colors
val EpCyan = Color(0xFF00f5d4)
val EpPink = Color(0xFFff006e)
val EpPurple = Color(0xFF8338ec)
val EpYellow = Color(0xFFffbe0b)
val EpBlue = Color(0xFF3a86ff)
val EpGreen = Color(0xFF06d6a0)
val EpOrange = Color(0xFFfb5607)

// Console dot colors
val DotRed = Color(0xFFff5f56)
val DotYellow = Color(0xFFffbd2e)
val DotGreen = Color(0xFF27c93f)

enum class EventVariant {
    Cyan, Green, Purple, Orange;

    val color: Color
        get() = when (this) {
            Cyan -> EpCyan
            Green -> EpGreen
            Purple -> EpPurple
            Orange -> EpOrange
        }

    val backgroundColor: Color
        get() = color.copy(alpha = 0.15f)
}
