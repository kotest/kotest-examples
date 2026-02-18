import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(commonLibs.plugins.kotlin.jvm)
   alias(commonLibs.plugins.spring.boot)
   alias(commonLibs.plugins.kotlin.plugin.spring)
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
   implementation(commonLibs.spring.boot.starter.webflux)
   implementation(commonLibs.jackson.module.kotlin)
   implementation(commonLibs.reactor.kotlin.extensions)
   implementation(commonLibs.kotlinx.coroutines.reactor)

   testImplementation(commonLibs.springmockk)
   testImplementation(commonLibs.kotest.runner.junit5)
   testImplementation(commonLibs.kotest.extensions.spring)
   testImplementation(commonLibs.reactor.test)
   testImplementation(commonLibs.spring.boot.webtestclient)
   testImplementation(commonLibs.spring.boot.starter.test) {
      exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
      exclude(module = "mockito-core")
   }
}

tasks.test {
   useJUnitPlatform()
}
