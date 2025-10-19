package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.string.shouldNotBeEmpty

class DataTests : FunSpec() {
   init {
      withData(listOf("foo", "bar", "baz")) {
         it.shouldNotBeEmpty()
      }
   }
}
