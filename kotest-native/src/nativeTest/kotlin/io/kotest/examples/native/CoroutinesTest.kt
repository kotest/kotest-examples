package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.delay

class CoroutinesTest : FunSpec({

   context("kotest native allows nested tests") {
      delay(10) // look ma, I can use coroutines here!
      test("a leaf test") {
         delay(10) // look ma, I can use coroutines here!
      }
   }
})
