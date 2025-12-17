package com.example.pizzadelivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzadelivery.R
import com.example.pizzadelivery.theme.*

@Composable
fun FloatingConsoleButton(
    eventCount: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
                ambientColor = EpBackground.copy(alpha = 0.3f),
                spotColor = EpBackground.copy(alpha = 0.3f)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(EpCard)
            .border(1.dp, EpCyan, RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_terminal),
            contentDescription = "Terminal",
            tint = EpCyan,
            modifier = Modifier.size(18.dp)
        )

        Text(
            text = "Console",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = EpCyan
        )

        if (eventCount > 0) {
            Text(
                text = "$eventCount",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = EpBackground,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(EpCyan)
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}
