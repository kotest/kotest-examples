package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withContexts
import io.kotest.datatest.withTests
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class DataTests : FunSpec() {
   init {
      test("my test") {}
      context("my context, no nested tests") {
      }
      context("my context, with nested tests") {
         test("nested test a") {}
         test("nested test b") {
            delay(100.milliseconds)
         }
      }
      withContexts(listOf("foo", "bar", "baz")) {
         withTests("tinker", "tailor", "soldier", "sailor") {
            1 + 1 shouldBe 2
         }
      }
   }
}

