// Generated using EventPanel — https://github.com/eventpanel/eventpanel-cli

package com.example.pizzadelivery

internal object GeneratedAnalyticsEvents {
  /**
   * A screen with user data
   */
  internal object ProfileScreen {

    internal fun profileScreenShown(): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Profile Screen Shown",
        parameters = emptyMap()
      )
    }

    /**
     * Screen is fully closed
     */
    internal fun profileScreenClosed(): AnalyticsEvent {
      return AnalyticsEvent(
        name = "Profile Screen Closed",
        parameters = emptyMap()
      )
    }
  }

  internal fun onboardingScreenShown(  
    origin: Origin?
  ): AnalyticsEvent {
    return AnalyticsEvent(
      name = "Onboarding Screen Shown",
      parameters = mapOf(
        "origin" to origin
      ).withoutNulls()
    )
  }
  /**
   * The user sees the full screen loading indicator
   * @param city_id The id of the city
   */
  internal fun loadingScreenShown(  
    cityId: String?
  ): AnalyticsEvent {
    return AnalyticsEvent(
      name = "Loading Screen Shown",
      parameters = mapOf(
        "city_id" to cityId
      ).withoutNulls()
    )
  }
}

// Custom types for 
internal enum class Origin(val value: String) {
  Facebook("Facebook"),
  Insta("Insta")
}

private fun Map<String, Any?>.withoutNulls(): Map<String, Any> =
    this.filterValues { it != null }.mapValues { it.value!! }
