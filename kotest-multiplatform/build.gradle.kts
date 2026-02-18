import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
   alias(commonLibs.plugins.kotlin.multiplatform)
   alias(commonLibs.plugins.kotest)
   alias(commonLibs.plugins.ksp)
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
                  // Serve sources to debug inside the browser
               static(rootDirPath)
               static(projectDirPath)
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
            implementation(commonLibs.kotest.framework.engine)
            implementation(commonLibs.kotest.assertions.core)
         }
      }
      jvmTest {
         dependencies {
            implementation(commonLibs.kotest.runner.junit5)
         }
      }
   }
}

tasks.named<Test>("jvmTest") {
   useJUnitPlatform()
   filter {
      isFailOnNoMatchingTests = false
   }
}
