plugins {
   alias(libs.plugins.android.library)
   alias(libs.plugins.jetbrains.kotlin.android)
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

   packaging {
      resources {
         excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE*.md}"
      }
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_21
      targetCompatibility = JavaVersion.VERSION_21
   }

   @Suppress("UnstableApiUsage")
   testOptions {
      unitTests.all {
         it.useJUnitPlatform()
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

tasks.withType<AbstractTestTask>().configureEach {
   failOnNoDiscoveredTests = false
   outputs.upToDateWhen { false }
}

dependencies {
   implementation(libs.kotest.framework)
   implementation(libs.mockk.android)
   implementation(libs.mockk.agent)

   testImplementation(libs.kotest.runner.junit5)
   testImplementation(libs.kotest.assertions)
}
