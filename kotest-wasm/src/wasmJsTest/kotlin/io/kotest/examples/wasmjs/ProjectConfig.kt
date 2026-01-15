package io.kotest.examples.wasmjs

import io.kotest.core.config.AbstractProjectConfig

class ProjectConfig : AbstractProjectConfig() {

   override suspend fun beforeProject() {
      println("beforeProjectListener!")
   }

   override suspend fun afterProject() {
      println("afterProjectListener!")
   }
}
