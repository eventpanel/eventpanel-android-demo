plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.pizzadelivery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pizzadelivery"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

val generateAnalyticsEvents by tasks.registering(Exec::class) {
    group = "code generation"
    description = "Generate analytics events using EventPanel CLI"

    val eventpanelPath = when {
        System.getProperty("os.name").lowercase().contains("mac") -> {
            val homebrewPath = "/opt/homebrew/bin/eventpanel"
            val systemPath = "eventpanel"
            if (file(homebrewPath).exists()) homebrewPath else systemPath
        }
        else -> "eventpanel"
    }
    println("Root project directory: ${rootProject.projectDir.absolutePath}")

    commandLine(eventpanelPath, "generate")

    workingDir = rootProject.projectDir

    commandLine(eventpanelPath, "generate")

    doFirst {
        file("src/main/java/com/example/pizzadelivery").mkdirs()
        println("Running EventPanel CLI from: ${workingDir.absolutePath}")
    }

    inputs.file(rootProject.file("EventPanel.yaml"))
    outputs.file("src/main/java/com/example/pizzadelivery/GeneratedAnalyticsEvents.kt")
}

tasks.named("preBuild") {
    dependsOn(generateAnalyticsEvents)
}