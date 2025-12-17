package com.example.pizzadelivery.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzadelivery.theme.*

@Composable
fun EventButtonView(
    label: String,
    badges: List<String>,
    variant: EventVariant,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(100),
        label = "scale"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isPressed) variant.color else EpBorder,
        animationSpec = tween(100),
        label = "borderColor"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) variant.color.copy(alpha = 0.15f) else EpCard,
        animationSpec = tween(100),
        label = "backgroundColor"
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .scale(scale)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(10.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = EpTextPrimary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            badges.forEach { badge ->
                Badge(
                    text = badge,
                    variant = variant
                )
            }
        }
    }
}

@Composable
private fun Badge(
    text: String,
    variant: EventVariant
) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.Monospace,
        color = variant.color,
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(variant.backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}
