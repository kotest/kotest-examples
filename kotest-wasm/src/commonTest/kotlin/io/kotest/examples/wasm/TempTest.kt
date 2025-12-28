package io.kotest.examples.wasm

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TempTest : FunSpec() {
   init {
      test("convert c to f") {
         celsiusToFahrenheit(0) shouldBe 32
         celsiusToFahrenheit(100) shouldBe 212
      }
   }
}
