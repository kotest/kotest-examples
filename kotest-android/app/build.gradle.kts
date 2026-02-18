import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
   alias(commonLibs.plugins.android.application)
   alias(commonLibs.plugins.jetbrains.kotlin.android)
   alias(commonLibs.plugins.jetbrains.kotlin.compose)
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
   val composeBom = platform(commonLibs.androidx.compose.bom)
   implementation(composeBom)
   testImplementation(composeBom)
   androidTestImplementation(composeBom)

   implementation(commonLibs.androidx.core.ktx)
   implementation(commonLibs.androidx.appcompat)
   implementation(commonLibs.material)

   implementation(commonLibs.junit)

   testImplementation(commonLibs.junit)
   testImplementation(commonLibs.kotest.framework)
   testImplementation(commonLibs.kotest.assertions)
   testImplementation(commonLibs.kotest.runner.junit5)
   testImplementation(commonLibs.mockk.android)
   testImplementation(commonLibs.mockk.agent)

   // dependencies for device-side tests
   androidTestImplementation(commonLibs.kotest.framework)
   androidTestImplementation(commonLibs.kotest.assertions)
   androidTestImplementation(commonLibs.kotest.runner.junit4)
   androidTestImplementation(commonLibs.androidx.junit)
   androidTestImplementation(commonLibs.androidx.test.runner)
   androidTestImplementation(commonLibs.androidx.ui.test.junit4)

   debugImplementation(commonLibs.androidx.ui.test.manifest)
}
