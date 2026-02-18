import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(commonLibs.plugins.kotlin.jvm)
   alias(commonLibs.plugins.allure)
}

group = "io.kotest.examples"
version = "0.0.1-SNAPSHOT"

java {
   sourceCompatibility = JavaVersion.VERSION_17
   targetCompatibility = JavaVersion.VERSION_17
   withSourcesJar()
}

kotlin {
   compilerOptions {
      jvmTarget = JvmTarget.JVM_17
      languageVersion = KotlinVersion.KOTLIN_2_2
      apiVersion = KotlinVersion.KOTLIN_2_2
   }
}

dependencies {
   implementation(kotlin("stdlib"))
   implementation(kotlin("reflect"))
   testImplementation(commonLibs.kotest.extensions.allure)
   testImplementation(commonLibs.kotest.runner.junit5)
}

tasks.withType<Test> {
   useJUnitPlatform()
   testLogging {
      showExceptions = true
      showStandardStreams = true
      exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
   }
}

allure {
   adapter.autoconfigure.set(false)
   version.set(commonLibs.versions.allure.report.get())
}
