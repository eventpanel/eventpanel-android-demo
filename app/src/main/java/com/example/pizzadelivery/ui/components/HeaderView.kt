package com.example.pizzadelivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzadelivery.R
import com.example.pizzadelivery.theme.EpTextSecondary

@Composable
fun HeaderView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "EventPanel Logo",
            modifier = Modifier.widthIn(max = 300.dp)
        )

        Text(
            text = "Type-safe analytics events for Kotlin",
            fontSize = 14.sp,
            color = EpTextSecondary
        )
    }
}
