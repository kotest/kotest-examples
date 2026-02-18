import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   id("org.springframework.boot") version "4.0.1"
   alias(libs.plugins.kotlin.jvm)
   alias(libs.plugins.kotlin.plugin.spring)
}

apply(plugin = "io.spring.dependency-management")

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
   implementation(kotlin("reflect"))
   implementation(libs.spring.boot.starter.webflux)
   implementation(libs.jackson.module.kotlin)
   implementation(libs.reactor.kotlin.extensions)
   implementation(libs.kotlinx.coroutines.reactor)

   testImplementation(libs.springmockk)
   testImplementation(libs.kotest.runner.junit5)
   testImplementation(libs.kotest.extensions.spring)
   testImplementation(libs.reactor.test)
   testImplementation(libs.spring.boot.webtestclient)
   testImplementation(libs.spring.boot.starter.test) {
      exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
      exclude(module = "mockito-core")
   }
}

tasks.test {
   useJUnitPlatform()
}
