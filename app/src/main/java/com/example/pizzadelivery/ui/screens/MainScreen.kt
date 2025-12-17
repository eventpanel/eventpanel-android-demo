package com.example.pizzadelivery.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.pizzadelivery.EntrySource
import com.example.pizzadelivery.GeneratedAnalyticsEvents
import com.example.pizzadelivery.PaymentMethod
import com.example.pizzadelivery.R
import com.example.pizzadelivery.services.AnalyticsService
import com.example.pizzadelivery.theme.*
import com.example.pizzadelivery.ui.components.*

@Composable
fun MainScreen() {
    val eventHistory by AnalyticsService.eventHistory.collectAsState()
    var showConsole by remember { mutableStateOf(false) }
    val context = LocalContext.current
    
    val sourceCodeUrl = "https://github.com/eventpanel/eventpanel-android-demo/blob/main/app/src/main/java/com/example/pizzadelivery/GeneratedAnalyticsEvents.kt"

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundGradient {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 80.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                
                HeaderView()

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    HomeCard()
                    ProductDetailsCard()
                    CheckoutCard()
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Source code link
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(20.dp))
                        .background(EpTextPrimary.copy(alpha = 0.1f))
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sourceCodeUrl))
                            context.startActivity(intent)
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_code),
                        contentDescription = null,
                        tint = EpTextPrimary.copy(alpha = 0.7f),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "View Analytics Source Code",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = EpTextPrimary.copy(alpha = 0.7f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_outward),
                        contentDescription = null,
                        tint = EpTextPrimary.copy(alpha = 0.7f),
                        modifier = Modifier.size(12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }

        // Floating console button
        FloatingConsoleButton(
            eventCount = eventHistory.size,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 30.dp),
            onClick = { showConsole = true }
        )
    }

    // Full screen console dialog
    if (showConsole) {
        Dialog(
            onDismissRequest = { showConsole = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        ) {
            ConsoleModalView(
                events = eventHistory,
                onClear = { AnalyticsService.clearHistory() },
                onClose = { showConsole = false },
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            )
        }
    }
}

@Composable
private fun HomeCard() {
    EventCardView(
        title = "Home Events",
        icon = "🏠",
        variant = EventVariant.Cyan
    ) {
        EventButtonView(
            label = "Screen Viewed (Google)",
            badges = listOf("entry_source"),
            variant = EventVariant.Cyan,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Home.homeScreenViewed(
                        activeExperiments = "exp_123",
                        screenLoadTimeMs = 245.5,
                        entrySource = EntrySource.Google
                    )
                )
            }
        )
        EventButtonView(
            label = "Screen Viewed (Facebook)",
            badges = listOf("entry_source"),
            variant = EventVariant.Cyan,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Home.homeScreenViewed(
                        activeExperiments = null,
                        screenLoadTimeMs = 180.0,
                        entrySource = EntrySource.Facebook
                    )
                )
            }
        )
        EventButtonView(
            label = "Banner Tapped",
            badges = listOf("banner_id", "position"),
            variant = EventVariant.Cyan,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Home.homeBannerTapped(
                        bannerMetadata = mapOf("campaign" to "summer_sale", "variant" to "A"),
                        bannerPosition = 1,
                        bannerId = "banner_001"
                    )
                )
            }
        )
        EventButtonView(
            label = "Quick Action",
            badges = listOf("actions[]"),
            variant = EventVariant.Cyan,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Home.quickActionTapped(
                        availableActions = listOf("search", "cart", "profile"),
                        actionType = "search",
                        isCustomized = true
                    )
                )
            }
        )
    }
}

@Composable
private fun ProductDetailsCard() {
    EventCardView(
        title = "Product Details",
        icon = "📦",
        variant = EventVariant.Purple
    ) {
        EventButtonView(
            label = "Product Viewed",
            badges = listOf("product_id", "price"),
            variant = EventVariant.Purple,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.ProductDetails.productViewed(
                        productId = "SKU-12345",
                        productPrice = "$99.99"
                    )
                )
            }
        )
        EventButtonView(
            label = "Add to Cart",
            badges = listOf("options[]"),
            variant = EventVariant.Purple,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.ProductDetails.addToCartTapped(
                        productId = "SKU-12345",
                        productPrice = "$99.99",
                        selectedOptions = listOf(1, 3, 5)
                    )
                )
            }
        )
        EventButtonView(
            label = "Gallery Swiped",
            badges = listOf("index"),
            variant = EventVariant.Purple,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.ProductDetails.imageGallerySwiped(
                        imageIndex = 2
                    )
                )
            }
        )
        EventButtonView(
            label = "Checkout Started",
            badges = listOf("cart_items[]"),
            variant = EventVariant.Purple,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.ProductDetails.checkoutStarted(
                        cartId = "cart_abc",
                        cartValue = 199.98,
                        cartItems = listOf(
                            mapOf("id" to "SKU-12345", "qty" to 2),
                            mapOf("id" to "SKU-67890", "qty" to 1)
                        )
                    )
                )
            }
        )
    }
}

@Composable
private fun CheckoutCard() {
    EventCardView(
        title = "Checkout Events",
        icon = "💳",
        variant = EventVariant.Green
    ) {
        EventButtonView(
            label = "Payment (Card)",
            badges = listOf("payment_method"),
            variant = EventVariant.Green,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Checkout.paymentMethodSelected(
                        paymentMetadata = listOf(mapOf("type" to "visa", "last4" to "4242")),
                        paymentMethod = PaymentMethod.Card,
                        supportedMethods = listOf("card", "cash", "google_pay")
                    )
                )
            }
        )
        EventButtonView(
            label = "Payment (Cash)",
            badges = listOf("payment_method"),
            variant = EventVariant.Green,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Checkout.paymentMethodSelected(
                        paymentMetadata = emptyList<Map<String, Any>>(),
                        paymentMethod = PaymentMethod.Cash,
                        supportedMethods = listOf("card", "cash")
                    )
                )
            }
        )
        EventButtonView(
            label = "Checkout Completed",
            badges = listOf("order_id"),
            variant = EventVariant.Green,
            onClick = {
                AnalyticsService.track(
                    GeneratedAnalyticsEvents.Checkout.checkoutCompleted(
                        totalAmount = 19998,
                        orderSummary = "2 items",
                        orderId = "ORD-2024-001"
                    )
                )
            }
        )
    }
}
