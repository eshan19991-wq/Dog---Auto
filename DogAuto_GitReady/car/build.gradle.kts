
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.dogauto.car"
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation("androidx.car.app:app:1.3.0")
}
