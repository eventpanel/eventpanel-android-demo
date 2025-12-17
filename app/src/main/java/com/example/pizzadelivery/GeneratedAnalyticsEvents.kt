// Generated using EventPanel — https://github.com/eventpanel/eventpanel-cli

package com.example.pizzadelivery

internal object GeneratedAnalyticsEvents {
  /**
   * Tracks user behavior on product detail screens
   */
  internal object ProductDetails {

    /**
     * Triggered when a user adds a product to the cart
     * @param product_id Unique product identifier
     */
    internal fun addToCartTapped(  
      productId: String,
      productPrice: String,
      selectedOptions: List<Int>
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Add To Cart Tapped",
        parameters = mapOf(
          "product_id" to productId,
          "product_price" to productPrice,
          "selected_options" to selectedOptions
        )
      )
    }

    /**
     * riggered when a user enters the checkout flow
     */
    internal fun checkoutStarted(  
      cartId: String?,
      cartValue: Double?,
      cartItems: List<Map<String, Any>>?
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Checkout Started",
        parameters = mapOf(
          "cart_id" to cartId,
          "cart_value" to cartValue,
          "cart_items" to cartItems
        ).withoutNulls()
      )
    }

    /**
     * Triggered when a user swipes through product images
     */
    internal fun imageGallerySwiped(  
      imageIndex: Int
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Image Gallery Swiped",
        parameters = mapOf(
          "image_index" to imageIndex
        )
      )
    }

    /**
     * Triggered when a product detail screen is opened
     * @param product_id Unique product identifier
     */
    internal fun productViewed(  
      productId: String,
      productPrice: String
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Product Viewed",
        parameters = mapOf(
          "product_id" to productId,
          "product_price" to productPrice
        )
      )
    }
  }
  /**
   * Monitors user progress and completion of checkout
   */
  internal object Checkout {

    /**
     * Triggered when the purchase is successfully completed
     */
    internal fun checkoutCompleted(  
      totalAmount: Int?,
      orderSummary: String?,
      orderId: String?
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Checkout Completed",
        parameters = mapOf(
          "total_amount" to totalAmount,
          "order_summary" to orderSummary,
          "order_id" to orderId
        ).withoutNulls()
      )
    }

    /**
     * Triggered when a user selects a payment method
     */
    internal fun paymentMethodSelected(  
      paymentMetadata: List<Map<String, Any>>,
      paymentMethod: PaymentMethod,
      supportedMethods: List<String>
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Payment Method Selected",
        parameters = mapOf(
          "payment_metadata" to paymentMetadata,
          "payment_method" to paymentMethod,
          "supported_methods" to supportedMethods
        )
      )
    }
  }
  /**
   * Measures user interaction with the home screen
   */
  internal object Home {

    /**
     * Triggered when a user taps a promotional banner
     * @param banner_metadata Additional banner details (campaign, variant)
     * @param banner_position Position of the banner on the screen
     * @param banner_id Unique identifier of the banner
     */
    internal fun homeBannerTapped(  
      bannerMetadata: Map<String, Any>,
      bannerPosition: Int,
      bannerId: String?
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Home Banner Tapped",
        parameters = mapOf(
          "banner_metadata" to bannerMetadata,
          "banner_position" to bannerPosition,
          "banner_id" to bannerId
        ).withoutNulls()
      )
    }

    /**
     * Triggered when the home screen is displayed
     * @param screen_load_time_ms Time taken to load the home screen
     * @param entry_source Source the user came from
     */
    internal fun homeScreenViewed(  
      activeExperiments: String?,
      screenLoadTimeMs: Double?,
      entrySource: EntrySource?
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Home Screen Viewed",
        parameters = mapOf(
          "active_experiments" to activeExperiments,
          "screen_load_time_ms" to screenLoadTimeMs,
          "entry_source" to entrySource
        ).withoutNulls()
      )
    }

    /**
     * Triggered when a user taps a quick action shortcut
     * @param available_actions List of visible quick actions
     * @param is_customized Whether the action was user-customized
     */
    internal fun quickActionTapped(  
      availableActions: List<String>,
      actionType: String,
      isCustomized: Boolean?
    ): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Quick Action Tapped",
        parameters = mapOf(
          "available_actions" to availableActions,
          "action_type" to actionType,
          "is_customized" to isCustomized
        ).withoutNulls()
      )
    }
  }

}

// Custom types for 
internal enum class PaymentMethod(val value: String) {
  Cash("cash"),
  Card("card")
}
internal enum class EntrySource(val value: String) {
  Google("google"),
  Facebook("facebook")
}

private fun Map<String, Any?>.withoutNulls(): Map<String, Any> =
    this.filterValues { it != null }.mapValues { it.value!! }
