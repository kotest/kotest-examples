plugins {
   alias(commonLibs.plugins.android.library)
   alias(commonLibs.plugins.jetbrains.kotlin.android)
}
android {
   namespace = "io.kotest.examples.android.shared"
   compileSdk = 36

   defaultConfig {
      minSdk = 26
      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      release {
         isMinifyEnabled = true
      }
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_11
      targetCompatibility = JavaVersion.VERSION_11
   }

   @Suppress("UnstableApiUsage")
   testOptions {
      unitTests.all {
         it.useJUnit()
      }
      animationsDisabled = true
      managedDevices {
         localDevices {
            create("pixel9a_api30") {
               device = "Pixel 9a"
               apiLevel = 30
               systemImageSource = "google"
            }
         }
      }
   }
}

dependencies {
   testImplementation(commonLibs.mockk.android)
   testImplementation(commonLibs.kotest.assertions)
   testImplementation(commonLibs.kotest.junit5)

   androidTestImplementation(commonLibs.androidx.junit)
   testImplementation(commonLibs.kotest.junit4)
}
