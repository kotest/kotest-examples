package io.kotest.examples.multiplatform

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

// this test only runs for native implementations
class UUIDNativeTest : FunSpec() {
   init {
      test("uuids should have length 15") {
         generateUniqueId().value.shouldHaveLength(15)
      }
   }
}
