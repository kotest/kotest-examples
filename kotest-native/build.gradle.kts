import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.ksp)
   alias(libs.plugins.kotest)
}

kotlin {

   compilerOptions {
      languageVersion = KotlinVersion.KOTLIN_2_3
      apiVersion = KotlinVersion.KOTLIN_2_3
   }

   linuxX64()
   mingwX64()
   macosX64()
   iosX64()

   sourceSets {
      commonTest {
         dependencies {
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.assertions.core)
            implementation(kotlin("test"))
         }
      }
   }
}

kotest {
   alwaysRerunTests = true
}
