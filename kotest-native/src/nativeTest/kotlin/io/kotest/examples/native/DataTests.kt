package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withTests
import io.kotest.matchers.string.shouldStartWith

class DataTests : FunSpec() {
   init {
      withTests("tinker", "tailor", "teacher") { name ->
         name.shouldStartWith("t")
      }
   }
}

