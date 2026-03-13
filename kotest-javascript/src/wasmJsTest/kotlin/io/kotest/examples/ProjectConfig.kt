package io.kotest.examples

import io.kotest.core.config.AbstractProjectConfig

class ProjectConfig : AbstractProjectConfig() {

   override suspend fun beforeProject() {
      println("Hello from WasmJS!")
   }

   override suspend fun afterProject() {
      println("Goodbye from WasmJS!")
   }
}
