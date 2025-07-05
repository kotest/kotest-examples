import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
   id("org.springframework.boot") version "2.7.18"
   alias(libs.plugins.kotlin.jvm)
   alias(libs.plugins.kotlin.plugin.spring)
}

apply(plugin = "io.spring.dependency-management")

repositories {
   mavenCentral()
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

extra["kotlinx-coroutines.version"] = "1.6.2"

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
   testImplementation(libs.spring.boot.starter.test) {
      exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
      exclude(module = "mockito-core")
   }
}

tasks.withType<Test> {
   useJUnitPlatform()
   filter {
      isFailOnNoMatchingTests = false
   }
}

tasks.withType<KotlinCompile> {
   kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "1.8"
   }
}
