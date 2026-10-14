pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
        maven("https://central.sonatype.com/repository/maven-snapshots")
    }
}

apply(from = "../../kotest-plugin-override.settings.gradle.kts")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://central.sonatype.com/repository/maven-snapshots")
    }
    // catalog lives in the composite root, so kotest-version-override.settings.gradle.kts can't be used
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
            System.getenv("KOTEST_VERSION")?.let { version("kotest", it) }
        }
    }
}

rootProject.name = "service-a"
