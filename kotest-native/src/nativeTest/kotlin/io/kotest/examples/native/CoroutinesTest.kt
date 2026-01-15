package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import kotlinx.coroutines.delay

class CoroutinesTest : FunSpec({

   test("tests support suspendable functions") {
      delay(10) // look ma, I can use coroutines here!
   }
})
