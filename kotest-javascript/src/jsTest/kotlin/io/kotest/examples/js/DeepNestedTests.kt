package io.kotest.examples.js

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DeepNestedTests : FreeSpec() {
   init {
      "some outer context" - {
         "some inner context" - {
            "some test" {
               1 shouldBe 1
            }
         }
         "another inner context" - {
            "another test" {
               1 shouldBe 1
            }
         }
      }
   }
}
