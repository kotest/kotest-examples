import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   kotlin("jvm") version "2.2.10"
   id("io.qameta.allure") version "2.12.0"
}

group = "io.kotest.examples"
version = "0.0.1-SNAPSHOT"

java {
   sourceCompatibility = JavaVersion.VERSION_11
   targetCompatibility = JavaVersion.VERSION_11
   withSourcesJar()
}

kotlin {
   compilerOptions {
      jvmTarget = JvmTarget.JVM_11
      languageVersion = KotlinVersion.KOTLIN_2_2
      apiVersion = KotlinVersion.KOTLIN_2_2
   }
}

dependencies {
   implementation(kotlin("stdlib"))
   implementation(kotlin("reflect"))
   testImplementation("io.kotest:kotest-extensions-allure:6.0.7")
   testImplementation("io.kotest:kotest-runner-junit5:6.0.4")
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
   version.set("2.29.1")
}
