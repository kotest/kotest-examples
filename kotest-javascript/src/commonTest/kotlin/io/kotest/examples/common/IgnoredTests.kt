package io.kotest.examples.common

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class `00IgnoredTests` : ShouldSpec() {
   init {
      xshould("ignored by x method") {
         1 shouldBe 2
      }
      should("ignored by config").config(enabled = false) {
         "a" shouldBe "b"
      }
   }
}
