import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.0.0-beta04"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.4.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    add(PLUGIN_CLASSPATH_CONFIGURATION_NAME, "androidx.compose.compiler:compiler:1.1.0-alpha01")
    implementation("androidx.compose.runtime:runtime:1.1.0-alpha01")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.0-alpha01")
    implementation("androidx.compose.ui:ui:1.1.0-alpha01")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:1.1.0-alpha01")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation ("androidx.compose.foundation:foundation:1.1.0-alpha01")
    // Material Design
    implementation ("androidx.compose.material:material:1.1.0-alpha01")
    // Material design icons
    implementation ("androidx.compose.material:material-icons-core:1.1.0-alpha01")
    implementation ("androidx.compose.material:material-icons-extended:1.1.0-alpha01")
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.3.1")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha03")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.example.droidskmmsample.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}