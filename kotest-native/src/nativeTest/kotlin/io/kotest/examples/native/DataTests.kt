package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withContexts
import io.kotest.datatest.withTests
import io.kotest.matchers.shouldBe

class DataTests : FunSpec() {
   init {
      withContexts(listOf("foo", "bar", "baz")) {
         withTests("tinker", "tailor", "soldier", "sailor") {
            1 + 1 shouldBe 2
         }
      }
   }
}

