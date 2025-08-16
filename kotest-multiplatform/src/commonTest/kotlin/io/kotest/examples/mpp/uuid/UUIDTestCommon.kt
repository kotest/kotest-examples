package io.kotest.examples.mpp.uuid

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.examples.multiplatform.generateUUID
import io.kotest.matchers.collections.shouldHaveSize

class UUIDTestCommon : DescribeSpec() {
   init {
      it("uuids should be somewhat unique!") {
         List(100) { generateUUID() }.toSet() shouldHaveSize 100
      }
   }
}
