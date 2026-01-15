package io.kotest.examples.multiplatform

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

// this test only runs for JS implementations
class UniqueIdJsTest : FunSpec() {
    init {
        test("Javascript implementations should have length 21") {
            generateUniqueId().value.shouldHaveLength(21)
        }
    }
}
