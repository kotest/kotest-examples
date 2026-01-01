import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin)
   id("org.gradle.test-retry") version "1.6.4"
}

repositories {
   mavenCentral()
   mavenLocal()
}

java {
   toolchain {
      languageVersion = JavaLanguageVersion.of(17)
   }
}

tasks.test {
   useJUnitPlatform()
   retry {
      maxRetries.set(10)
      maxFailures.set(10)
      failOnPassedAfterRetry.set(true)
      failOnSkippedAfterRetry.set(true)
   }
}

kotlin {

   compilerOptions {
      apiVersion = KotlinVersion.KOTLIN_2_2
      languageVersion = KotlinVersion.KOTLIN_2_2
   }

   sourceSets {
      test {
         dependencies {
            implementation(libs.kotest.runner.junit5)
            implementation(libs.kotest.assertions.core)
         }
      }
   }
}
