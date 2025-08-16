package io.kotest.examples.js

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SlugTest : FunSpec() {
   init {
      test("slugify should convert string to slug") {
         val result = slugme("some string")
         result shouldBe "some-string"
      }
   }
}
