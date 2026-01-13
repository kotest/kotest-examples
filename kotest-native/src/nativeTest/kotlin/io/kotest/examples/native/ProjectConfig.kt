package io.kotest.examples.native

import io.kotest.core.config.AbstractProjectConfig

class ProjectConfig : AbstractProjectConfig() {

   override suspend fun beforeProject() {
      println("beforeProjectInvoked!")
   }

   override suspend fun afterProject() {
      println("afterProjectInvoked!")
   }
}
