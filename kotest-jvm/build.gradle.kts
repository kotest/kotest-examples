import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin)
   alias(libs.plugins.kotest)
}

java {
   toolchain {
      languageVersion = JavaLanguageVersion.of(17)
   }
}

tasks.test {
   useJUnitPlatform()
      testLogging {
      showExceptions = true
      showStandardStreams = true
      events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
      exceptionFormat = TestExceptionFormat.FULL
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
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.runner.junit5)
            implementation(libs.kotest.assertions.core)
         }
      }
   }
}
