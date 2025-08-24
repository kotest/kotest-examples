pluginManagement {
   repositories {
      gradlePluginPortal()
      mavenLocal()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}

dependencyResolutionManagement {
   repositories {
      mavenLocal()
      mavenCentral()
      maven("https://central.sonatype.com/repository/maven-snapshots")
   }
}
