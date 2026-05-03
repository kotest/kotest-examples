package io.kotest.examples.jvm

import io.kotest.core.config.AbstractProjectConfig

/**
 * Example of product config.
 */
object ProjectConfig : AbstractProjectConfig() {
   override suspend fun beforeProject() {
      println("Kotest Amper is starting")
   }
}
