package io.kotest.examples.native

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SsnTest : FunSpec() {
   init {

      test("ssn should be invalid when it contains a zero ") {
         validateSocial("543-23-5013") shouldBe false
         validateSocial("043-23-5313") shouldBe false
         validateSocial("313-03-5310") shouldBe false
      }

      test("SSN should be invalid when it starts with 666 ") {
         validateSocial("666-23-1234") shouldBe false
      }

      test("ssn should be in the accepted format") {
         validateSocial("") shouldBe false
         validateSocial("123-45-678") shouldBe false
         validateSocial("12-45-6789") shouldBe false
         validateSocial("1234-56-678") shouldBe false
         validateSocial("123456789") shouldBe false
         validateSocial("123-456789") shouldBe false
         validateSocial("12345-6789") shouldBe false
         validateSocial("") shouldBe false
      }
   }
}
