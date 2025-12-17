package com.example.pizzadelivery.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = EpCyan,
    secondary = EpPurple,
    tertiary = EpGreen,
    background = EpBackground,
    surface = EpCard,
    onPrimary = EpBackground,
    onSecondary = EpTextPrimary,
    onTertiary = EpTextPrimary,
    onBackground = EpTextPrimary,
    onSurface = EpTextPrimary,
)

@Composable
fun EventPanelTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = EpBackground.toArgb()
            window.navigationBarColor = EpBackground.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
