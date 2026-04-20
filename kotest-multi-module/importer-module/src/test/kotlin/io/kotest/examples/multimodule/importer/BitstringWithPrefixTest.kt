package io.kotest.examples.multimodule.importer

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BitstringWithPrefixTest : FunSpec({

    test("should prepend prefix to bit string") {
        bitstringWithPrefix("0b", listOf(true, true, false)) shouldBe "0b110"
    }

    test("should work with single bit") {
        bitstringWithPrefix("bit:", listOf(false)) shouldBe "bit:0"
    }
})

