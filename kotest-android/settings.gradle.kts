@file:Suppress("UnstableApiUsage")

pluginManagement {
   repositories {
      google {
         content {
            includeGroupByRegex("com\\.android.*")
            includeGroupByRegex("com\\.google.*")
            includeGroupByRegex("androidx.*")
         }
      }
      mavenCentral()
      mavenLocal()
      gradlePluginPortal()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}

apply(from = "../kotest-plugin-override.settings.gradle.kts")
apply(from = "../kotest-version-override.settings.gradle.kts")

dependencyResolutionManagement {
   repositories {
      google()
      mavenCentral()
      mavenLocal()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}

rootProject.name = "Kotest Android Example"

include(":app")
//include(":shared")
