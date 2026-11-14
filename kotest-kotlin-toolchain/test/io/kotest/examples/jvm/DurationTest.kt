package io.kotest.examples.jvm

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class DurationTest : FunSpec({

   context("test suite") {
      delay(100.milliseconds) // look ma, I can use coroutines here!
      context("nested test suite") {
         delay(200.milliseconds) // look ma, I can use coroutines here!
         test("leaf test") {
            delay(300.milliseconds) // look ma, I can use coroutines here!
         }
      }
   }
})
