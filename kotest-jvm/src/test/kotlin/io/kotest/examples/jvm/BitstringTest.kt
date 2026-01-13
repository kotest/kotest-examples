package io.kotest.examples.jvm

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BitstringTest : DescribeSpec() {
   init {
      it("other test") {
      }
      it("other.test") {

      }
      describe("context") {
         it("!test") {
         }
         it("f:test2") {
         }
      }
   }
}
