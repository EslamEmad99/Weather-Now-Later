plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        buildConfig = true
    }

    /**
     * Using product flavors to create two different flavors (STG - LIVE)
     * to simulate the REAL-WORLD project
     * LIVE for the production version on app store
     * STG for testing
     */
    flavorDimensions.add("environment")
    productFlavors {
        create("stg") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"${project.properties["STG_BASE_URL"]}\"")
        }
        create("live") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"${project.properties["LIVE_BASE_URL"]}\"")
        }
    }
}

dependencies {
    implementation(project(":core"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Hilt
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)

    // Retrofit + Moshi
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)
    kapt(libs.moshiCodegen)

    // Room
    implementation(libs.roomRuntime)
    implementation(libs.roomKtx)
    kapt(libs.roomCompiler)

    // Coroutines
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)
}

kapt {
    correctErrorTypes = true
}