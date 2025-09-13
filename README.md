# EventPanel Android Demo

A demonstration Android app showcasing EventPanel CLI integration for type-safe analytics event code generation.

## Overview

This demo app demonstrates how to integrate EventPanel CLI into an Android project to generate type-safe analytics events from YAML configuration files.

## Features

- 🎯 **Type-Safe Analytics**: Generated analytics events with compile-time safety
- 📝 **YAML Configuration**: Event definitions managed through `EventPanel.yaml`
- 🔄 **Code Generation**: Automated Kotlin code generation from event schemas

## Generated Analytics Events

The app includes several example analytics events:

- **Profile Screen Events**: `profileScreenShown()`, `profileScreenClosed()`
- **Onboarding Events**: `onboardingScreenShown(origin:)` with custom `Origin` enum
- **Loading Events**: `loadingScreenShown(cityId:)` with optional parameters

## Usage

### Setup

1. **Install EventPanel CLI**:
   ```bash
   brew tap eventpanel/eventpanel
   brew install eventpanel
   ```

2. **Generate Analytics Code**:
   ```bash
   eventpanel generate
   ```
   
   **Note**: Code generation is automatically run during Android builds via the "generateAnalyticsEvents" Gradle task. The build script automatically detects the EventPanel CLI installation path (Homebrew or manual installation).

### Configuration

The app uses `EventPanel.yaml` to define analytics events:

```yaml
workspaceId: 00ab2c96-4e82-4166-b913-fb9aa7be6dbd
source: android
plugin:
  kotlingen:
    eventClassName: AnalyticsEvent
    generatedEventsPath: app/src/main/java/com/example/pizzadelivery/GeneratedAnalyticsEvents.kt
    documentation: true
    packageName: com.example.pizzadelivery
events:
- id: A0CNO9LW4q2jgr8s4nsrU
- id: Aae9pNlfoawHFaeM4ClwC
  version: 2
- id: Jd2R6diazU2cWzVguI8Rq
```

## Example Usage

```kotlin
// Track a profile screen view
val event = GeneratedAnalyticsEvents.ProfileScreen.profileScreenShown()
analytics.track(event)

// Track onboarding with origin
val onboardingEvent = GeneratedAnalyticsEvents.onboardingScreenShown(origin = Origin.Facebook)
analytics.track(onboardingEvent)

// Track loading with city ID
val loadingEvent = GeneratedAnalyticsEvents.loadingScreenShown(cityId = "NYC")
analytics.track(loadingEvent)
```

## Learn More

- 🚀 [EventPanel CLI](https://github.com/eventpanel/eventpanel-cli)
- 🌐 [EventPanel Website](https://eventpanel.net)
