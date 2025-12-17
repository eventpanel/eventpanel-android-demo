package com.example.pizzadelivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.pizzadelivery.theme.EpBackground
import com.example.pizzadelivery.theme.EpCyan
import com.example.pizzadelivery.theme.EpPink
import com.example.pizzadelivery.theme.EpPurple

@Composable
fun BackgroundGradient(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(EpBackground)
    ) {
        // Cyan gradient - top left
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            EpCyan.copy(alpha = 0.08f),
                            Color.Transparent
                        ),
                        center = Offset(0f, 0f),
                        radius = 800f
                    )
                )
        )

        // Purple gradient - top right
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            EpPurple.copy(alpha = 0.08f),
                            Color.Transparent
                        ),
                        center = Offset(Float.MAX_VALUE, 0f),
                        radius = 800f
                    )
                )
        )

        // Pink gradient - bottom
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            EpPink.copy(alpha = 0.05f),
                            Color.Transparent
                        ),
                        center = Offset(Float.MAX_VALUE / 2, Float.MAX_VALUE),
                        radius = 1000f
                    )
                )
        )

        content()
    }
}
