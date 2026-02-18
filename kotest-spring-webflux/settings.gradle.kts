pluginManagement {
   repositories {
      gradlePluginPortal()
      mavenLocal()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}

apply(from = "../kotest-plugin-override.settings.gradle.kts")
apply(from = "../kotest-version-override.settings.gradle.kts")

rootProject.name = "kotest-examples-spring-webflux"

dependencyResolutionManagement {
   repositories {
      mavenCentral()
      mavenLocal()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}
