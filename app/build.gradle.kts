plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.new_project"
    compileSdk = 34


    packagingOptions {
        exclude ("META-INF/INDEX.LIST")
        exclude ("META-INF/DEPENDENCIES")
    }

    defaultConfig {
        applicationId = "com.example.new_project"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        android.buildFeatures.buildConfig =true

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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.config)

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.code.gson:gson:2.8.8")


    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation ("com.sun.mail:android-mail:1.6.2")
    implementation ("com.sun.mail:android-activation:1.6.2")



    implementation ("com.google.cloud:google-cloud-dialogflow:2.1.0")
    implementation ("io.grpc:grpc-okhttp:1.30.0")














    implementation(libs.play.services.wallet)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.recyclerview)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}









