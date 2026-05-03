import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kotest) apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.kotest")

    extensions.configure<JavaPluginExtension> {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }

    tasks.named<Test>("test") {
        useJUnitPlatform()
        testLogging {
            showExceptions = true
            showStandardStreams = true
            events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
            exceptionFormat = TestExceptionFormat.FULL
        }
    }

    extensions.configure<KotlinJvmProjectExtension> {
        compilerOptions {
            apiVersion = KotlinVersion.KOTLIN_2_2
            languageVersion = KotlinVersion.KOTLIN_2_2
        }
    }

    dependencies {
        add("testImplementation", rootProject.libs.kotest.framework.engine)
        add("testImplementation", rootProject.libs.kotest.runner.junit5)
        add("testImplementation", rootProject.libs.kotest.assertions.core)
    }
}
