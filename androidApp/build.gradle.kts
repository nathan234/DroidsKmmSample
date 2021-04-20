import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.0.0-beta04"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    add(PLUGIN_CLASSPATH_CONFIGURATION_NAME, "androidx.compose.compiler:compiler:${composeVersion}")
    implementation("androidx.compose.runtime:runtime:${composeVersion}")
    implementation("androidx.compose.runtime:runtime-livedata:${composeVersion}")
    implementation("androidx.compose.ui:ui:${composeVersion}")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:${composeVersion}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation ("androidx.compose.foundation:foundation:${composeVersion}")
    // Material Design
    implementation ("androidx.compose.material:material:${composeVersion}")
    // Material design icons
    implementation ("androidx.compose.material:material-icons-core:${composeVersion}")
    implementation ("androidx.compose.material:material-icons-extended:${composeVersion}")
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.3.0-alpha06")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01")
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