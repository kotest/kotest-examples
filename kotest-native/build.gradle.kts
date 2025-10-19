import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinTest

plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest)
   alias(libs.plugins.ksp)
}

kotlin {
   compilerOptions {
      languageVersion = KotlinVersion.KOTLIN_2_2
      apiVersion = KotlinVersion.KOTLIN_2_2
   }

   linuxX64()
   mingwX64()
   macosX64()
   iosX64()

   sourceSets {
      nativeTest {
         dependencies {
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.assertions.core)
         }
      }
   }

   tasks.withType<KotlinTest>().configureEach {
      failOnNoDiscoveredTests = false
   }
}

