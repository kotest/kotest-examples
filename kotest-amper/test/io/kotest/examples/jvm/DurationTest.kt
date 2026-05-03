package io.kotest.examples.jvm

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.delay

class DurationTest : FunSpec({

   context("test suite") {
      delay(100) // look ma, I can use coroutines here!
      context("nested test suite") {
         delay(200) // look ma, I can use coroutines here!
         test("leaf test") {
            delay(300) // look ma, I can use coroutines here!
         }
      }
   }
})
