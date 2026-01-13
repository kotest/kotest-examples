package io.kotest.examples.multiplatform

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

// this test only runs for JVM implementations
class UniqueIdJvmTest : FunSpec() {
   init {
      test("unique ids on the JVM should have length 36") {
         generateUniqueId().value.shouldHaveLength(36)
      }
   }
}
