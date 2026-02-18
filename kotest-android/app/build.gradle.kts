import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.jetbrains.kotlin.android)
   alias(libs.plugins.jetbrains.kotlin.compose)
}

android {
   namespace = "com.example.kotestdemo"
   compileSdk = 36

   defaultConfig {
      applicationId = "com.example.kotestdemo"
      minSdk = 26
      targetSdk = 34
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildFeatures {
      compose = true
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlin {
      compilerOptions {
         jvmTarget = JvmTarget.JVM_1_8
      }
   }

   packaging {
      resources {
         excludes += "/META-INF/{AL2.0,LGPL2.1,LICENSE*.md}"
      }
   }

   testOptions {
      unitTests.all {
         it.useJUnitPlatform()
      }
   }
}

tasks.withType<AbstractTestTask>().configureEach {
   failOnNoDiscoveredTests = false
}

dependencies {
//   implementation(project(":shared"))

   // sets the versions for all the compose libraries
   val composeBom = platform(libs.androidx.compose.bom)
   implementation(composeBom)
   testImplementation(composeBom)
   androidTestImplementation(composeBom)

   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.appcompat)
   implementation(libs.material)

   implementation(libs.junit)

   testImplementation(libs.junit)
   testImplementation(libs.kotest.framework)
   testImplementation(libs.kotest.assertions)
   testImplementation(libs.kotest.runner.junit5)
   testImplementation(libs.mockk.android)
   testImplementation(libs.mockk.agent)

   // dependencies for device-side tests
   androidTestImplementation(libs.kotest.framework)
   androidTestImplementation(libs.kotest.assertions)
   androidTestImplementation(libs.kotest.runner.junit4)
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.test.runner)
   androidTestImplementation(libs.androidx.ui.test.junit4)

   debugImplementation(libs.androidx.ui.test.manifest)
}
