package io.kotest.examples.multiplatform

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize

class UniqueIdTestCommon : DescribeSpec() {
   init {
      it("unique ids should be somewhat unique!") {
         List(100) { generateUniqueId() }.toSet() shouldHaveSize 100
      }
   }
}
