package io.kotest.examples.js

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BitstringTest : DescribeSpec() {
   init {
      it("should set bits based on booleans 1") {
         bitstring(listOf(true, false, true, false, true)) shouldBe "10101"
         bitstring(listOf(false, false, false, false, false, false, false, true)) shouldBe "00000001"
      }
      it("should error on empty") {
         shouldThrowAny {
            bitstring(listOf())
         }
      }
   }
}
