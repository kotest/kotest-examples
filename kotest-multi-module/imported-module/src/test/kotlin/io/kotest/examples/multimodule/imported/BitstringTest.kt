package io.kotest.examples.multimodule.imported

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BitstringTest : FunSpec({

    test("should convert booleans to bit string") {
        bitstring(listOf(true, false, true)) shouldBe "101"
    }

    test("should throw on empty list") {
        val result = runCatching { bitstring(emptyList()) }
        result.isFailure shouldBe true
    }
})

