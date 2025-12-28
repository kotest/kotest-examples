@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest)
   id("com.google.devtools.ksp") version "2.2.21-2.0.4"
}

repositories {
   mavenCentral()
   mavenLocal()
}

kotlin {

   compilerOptions {
      apiVersion = KotlinVersion.KOTLIN_2_2
      languageVersion = KotlinVersion.KOTLIN_2_2
   }

   wasmJs {
      binaries.executable()
      browser()
//      nodejs()
   }

//   wasmWasi {
//      binaries.executable()
//      nodejs()
//   }

   sourceSets {
      commonTest {
         dependencies {
            implementation(libs.kotest.assertions.core)
            implementation(libs.kotest.framework.engine)
         }
      }
   }
}

tasks.withType<AbstractTestTask>().configureEach {
   failOnNoDiscoveredTests = false
}
