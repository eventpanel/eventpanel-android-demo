package com.example.pizzadelivery.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzadelivery.R
import com.example.pizzadelivery.services.TrackedEvent
import com.example.pizzadelivery.theme.*

@Composable
fun ConsoleModalView(
    events: List<TrackedEvent>,
    onClear: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(EpBackground)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(EpBackgroundSecondary)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Console",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = EpTextPrimary,
                modifier = Modifier.padding(start = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Clear button
                Text(
                    text = "Clear",
                    fontSize = 14.sp,
                    color = EpTextSecondary,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .border(1.dp, EpBorder, RoundedCornerShape(6.dp))
                        .clickable(onClick = onClear)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )

                // Close button
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close",
                    tint = EpTextSecondary,
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .clickable(onClick = onClose)
                        .padding(4.dp)
                )
            }
        }

        // Event list
        EventConsoleView(events = events)
    }
}

@Composable
fun EventConsoleView(
    events: List<TrackedEvent>,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    // Auto-scroll to bottom when new events added
    LaunchedEffect(events.size) {
        if (events.isNotEmpty()) {
            listState.animateScrollToItem(events.size - 1)
        }
    }

    if (events.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "📊",
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Click any event button to see\ngenerated analytics in action...",
                    fontSize = 14.sp,
                    color = EpTextMuted,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }
        }
    } else {
        LazyColumn(
            state = listState,
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(
                items = events,
                key = { it.id }
            ) { event ->
                EventLineView(event = event)
            }
        }
    }
}

@Composable
fun EventLineView(
    event: TrackedEvent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(EpBackgroundSecondary)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = event.name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Monospace,
                color = EpCyan
            )

            Text(
                text = event.formattedTime,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                color = EpTextMuted
            )
        }

        Text(
            text = event.parametersString,
            fontSize = 12.sp,
            fontFamily = FontFamily.Monospace,
            color = EpPurple
        )
    }
}
