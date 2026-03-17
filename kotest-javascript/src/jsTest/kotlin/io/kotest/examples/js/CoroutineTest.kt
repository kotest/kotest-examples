package io.kotest.examples.js

import io.kotest.core.spec.style.FreeSpec
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class CoroutineTest : FreeSpec() {
   init {
      "coroutines at the parent level" - {
         delay(10.milliseconds)
         "coroutines at the child level" {
            delay(5.milliseconds)
         }
      }
   }
}
