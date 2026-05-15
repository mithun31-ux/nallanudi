plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {

    namespace = "com.example.nallanudi"

    compileSdk = 34

    defaultConfig {

        applicationId = "com.example.nallanudi"

        minSdk = 24

        targetSdk = 34

        versionCode = 1

        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }

    kotlinOptions {

        jvmTarget = "11"
    }
}

dependencies {

    implementation(
        "androidx.recyclerview:recyclerview:1.3.2"
    )

    implementation(
        "androidx.core:core-splashscreen:1.0.1"
    )

    implementation(
        "com.google.android.material:material:1.11.0"
    )

    implementation(
        "androidx.room:room-runtime:2.6.1"
    )

    annotationProcessor("androidx.room:room-compiler:2.6.1")

    implementation(
        "androidx.room:room-ktx:2.6.1"
    )

    implementation(libs.androidx.activity.ktx)

    implementation(libs.androidx.appcompat)

    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.core.ktx)

    implementation(libs.material)

    testImplementation(libs.junit)

    androidTestImplementation(
        libs.androidx.espresso.core
    )

    androidTestImplementation(
        libs.androidx.junit
    )
}