import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest)
   alias(libs.plugins.ksp)
}

kotlin {

   compilerOptions {
      apiVersion = KotlinVersion.KOTLIN_2_2
      languageVersion = KotlinVersion.KOTLIN_2_2
      verbose = true
   }

   jvm()
   js {
      browser()
      nodejs()
   }

   @OptIn(ExperimentalWasmDsl::class)
   wasmJs {
      browser {
         testTask { useKarma { useChromeHeadless() } }
         val rootDirPath = project.rootDir.path
         val projectDirPath = project.projectDir.path
         commonWebpackConfig {
            devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
               static = (static ?: mutableListOf()).apply {
                  // Serve sources to debug inside browser
                  add(rootDirPath)
                  add(projectDirPath)
               }
            }
         }
      }
      nodejs()
   }

   linuxX64()
   linuxArm64()
   mingwX64()

   macosArm64()
   macosX64()
   iosX64()
   iosArm64()
   iosSimulatorArm64()
   watchosDeviceArm64()
   watchosSimulatorArm64()
   watchosX64()
   watchosArm32()
   watchosArm64()
   tvosSimulatorArm64()
   tvosX64()
   tvosArm64()

   // kotlin has no support for tests for androidNative targets, so they'll be skipped at runtime
   androidNativeX64()
   androidNativeX86()
   androidNativeArm32()
   androidNativeArm64()

   sourceSets {

      commonTest {
         dependencies {
            implementation(libs.kotest.framework.engine)
            implementation(libs.kotest.assertions.core)
         }
      }
   }
}
