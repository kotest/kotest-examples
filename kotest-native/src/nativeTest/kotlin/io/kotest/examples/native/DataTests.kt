package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withTests
import io.kotest.matchers.shouldBe

class DataTests : FunSpec() {
   init {
      withTests("tinker", "tailor", "soldier", "sailor") {
         1 + 1 shouldBe 2
      }
   }
}

