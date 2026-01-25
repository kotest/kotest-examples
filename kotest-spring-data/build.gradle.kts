import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("org.springframework.boot") version "4.0.1"
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.plugin.spring)
    alias(libs.plugins.kotlin.jpa)
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
    implementation(libs.bundles.spring.boot)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.flyway.database.postgresql)

    runtimeOnly(libs.postgresql)

    testImplementation(libs.bundles.spring.boot.test)
    testImplementation(libs.bundles.kotest)
    testImplementation(libs.postgresql.testcontainers)
}

tasks.test {
    useJUnitPlatform()
}

configurations {
    all {
        exclude(group = "org.mockito", module = "mockito-core")
        exclude(group = "org.mockito", module = "mockito-junit-jupiter")
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}