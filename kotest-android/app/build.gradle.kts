import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.jetbrains.kotlin.android)
   alias(libs.plugins.kotest)
}

android {
   namespace = "com.example.kotestdemo"
   compileSdk = 35

   defaultConfig {
      applicationId = "com.example.kotestdemo"
      minSdk = 26
      targetSdk = 34
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

tasks.withType<AbstractTestTask>().configureEach {
   failOnNoDiscoveredTests = false
}

dependencies {
   implementation(project(":shared"))

   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.appcompat)
   implementation(libs.material)

   implementation(libs.junit)

   testImplementation(libs.junit)
   testImplementation(libs.kotlin.reflect)
   testImplementation(libs.kotest.framework)
   testImplementation(libs.kotest.assertions)
   testImplementation(libs.kotest.runner.junit5)
   testImplementation(libs.mockk.android)
   testImplementation(libs.mockk.agent)

   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.espresso.core)
}
