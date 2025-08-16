@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest)
   id("com.google.devtools.ksp") version "2.2.0-2.0.2"
}

repositories {
   mavenLocal()
   mavenCentral()
}

kotlin {

   compilerOptions {
      apiVersion = KotlinVersion.KOTLIN_2_2
      languageVersion = KotlinVersion.KOTLIN_2_2
   }

   js {
      nodejs()
      browser()
   }

   wasmJs {
      nodejs()
      d8()
   }

   sourceSets {
      commonMain {
         dependencies {
            api(kotlin("stdlib"))
         }
      }
      commonTest {
         dependencies {
            implementation(libs.kotest.assertions.core)
            implementation(libs.kotest.framework.engine)
         }
      }
      jsMain {
         dependencies {
            api(kotlin("stdlib-js"))
            implementation(libs.ktor.client.js)
//            just to test npm deps
            implementation(npm("slugify", "1.6.6"))
//            needed as a workaround for https://youtrack.jetbrains.com/issue/KT-57235
            implementation("org.jetbrains.kotlin:kotlinx-atomicfu-runtime:2.1.10")
         }
      }
      wasmJsMain {
         dependencies {
            api(kotlin("stdlib-wasm-js"))
            implementation(libs.ktor.client.js)
            // just to test npm deps
            implementation(npm("slugify", "1.6.6"))
         }
      }
   }
}
