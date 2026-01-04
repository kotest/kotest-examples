package io.kotest.examples.native

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CluesTest : FunSpec() {
   init {
      test("assertions with clues") {
         withClue("my clue") {
            "a" shouldBe "b"
         }
      }
   }
}
