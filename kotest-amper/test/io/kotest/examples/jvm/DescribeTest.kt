package io.kotest.examples.jvm

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DescribeTest : DescribeSpec() {
   init {
      isolationMode = IsolationMode.InstancePerLeaf
      describe("tests") {
         describe("for") {
            it("should pass") {
               true shouldBe true
            }
            it("should pass too") {
               true shouldBe true
            }
         }
      }
   }
}
