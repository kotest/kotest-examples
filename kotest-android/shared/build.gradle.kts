plugins {
   alias(libs.plugins.android.library)
   alias(libs.plugins.jetbrains.kotlin.android)
   alias(libs.plugins.kotest)
}

android {
   namespace = "io.kotest.examples.android.shared"
   compileSdk = 35

   defaultConfig {
      minSdk = 26

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

   testOptions {
      unitTests.all {
         it.useJUnit()
      }
   }
}

dependencies {
   implementation(libs.mockk.android)
   implementation(libs.kotest.assertions)
   implementation(libs.kotest.framework)
   testImplementation(libs.junit)
   androidTestImplementation(libs.androidx.junit)
}
