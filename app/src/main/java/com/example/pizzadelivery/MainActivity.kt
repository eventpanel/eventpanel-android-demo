package com.example.pizzadelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pizzadelivery.theme.EpBackground
import com.example.pizzadelivery.theme.EventPanelTheme
import com.example.pizzadelivery.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventPanelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = EpBackground
                ) {
                    MainScreen()
                }
            }
        }
    }
}
