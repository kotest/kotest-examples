@file:Suppress("UnstableApiUsage")

rootProject.name = "kotest-wasm"

pluginManagement {
   resolutionStrategy {
      repositories {
         gradlePluginPortal()
         mavenLocal()
      }
   }
}

dependencyResolutionManagement {
   repositories {
      mavenCentral()
      mavenLocal()
   }
}
