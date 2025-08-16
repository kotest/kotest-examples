import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
   kotlin("jvm") version "1.6.21"
   id("io.qameta.allure") version "2.10.0"
}

repositories {
   mavenCentral()
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
   implementation(kotlin("stdlib"))
   implementation(kotlin("reflect"))
   testImplementation("io.kotest.extensions:kotest-extensions-allure:1.4.0")
   testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
}

tasks.withType<Test> {
   useJUnitPlatform()
   filter {
      isFailOnNoMatchingTests = false
   }
}

allure {
   adapter.autoconfigure.set(false)
   version.set("2.13.1")
}

tasks.withType<KotlinCompile> {
   kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "1.8"
   }
}
