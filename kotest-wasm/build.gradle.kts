@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(commonLibs.plugins.kotlin.multiplatform)
   alias(commonLibs.plugins.kotest)
   alias(commonLibs.plugins.ksp)
}

kotlin {

   compilerOptions {
      apiVersion = KotlinVersion.KOTLIN_2_2
      languageVersion = KotlinVersion.KOTLIN_2_2
   }

   wasmJs {
      binaries.executable()
      browser()
      nodejs()
      d8()
   }

   wasmWasi {
      binaries.executable()
      nodejs()
   }

   sourceSets {
      commonTest {
         dependencies {
            implementation(commonLibs.kotest.framework.engine)
            implementation(commonLibs.kotest.assertions.core)
         }
      }
   }
}

tasks.withType<AbstractTestTask>().configureEach {
   failOnNoDiscoveredTests = false
}
