plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotest)
}

kotlin { jvmToolchain(17) }

dependencies {
    testImplementation(libs.kotest.framework.engine)
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.assertions.core)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    environment("SERVICE_A_ENV", "from-test-task")
    workingDir = rootDir.parentFile
    // false when service-a is built on its own rather than as part of the composite
    systemProperty("composite", gradle.parent != null)
}
