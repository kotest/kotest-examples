import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin)
   alias(libs.plugins.kotest)
   alias(libs.plugins.retry)
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

   reports {
      html.required.set(false)
      junitXml.required.set(true)
   }

   retry {
      maxRetries.set(100)
      maxFailures.set(100)
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
