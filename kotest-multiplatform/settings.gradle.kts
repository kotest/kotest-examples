pluginManagement {
   repositories {
      google {
         mavenContent {
            includeGroupAndSubgroups("androidx")
            includeGroupAndSubgroups("com.android")
            includeGroupAndSubgroups("com.google")
         }
      }
      mavenCentral()
      gradlePluginPortal()
      mavenLocal()
   }
}

dependencyResolutionManagement {
   repositories {
      google {
         mavenContent {
            includeGroupAndSubgroups("androidx")
            includeGroupAndSubgroups("com.android")
            includeGroupAndSubgroups("com.google")
         }
      }
      mavenCentral()
      mavenLocal()
   }
}
