package io.kotest.examples.wasm

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class EmailTest : FunSpec({

   test("happy path") {
      validateEmail("sam@foo.com") shouldBe true
   }

   test("an email should be in the required format") {
      validateEmail("bill@bill") shouldBe false
      validateEmail("johny.com") shouldBe false
   }

})
