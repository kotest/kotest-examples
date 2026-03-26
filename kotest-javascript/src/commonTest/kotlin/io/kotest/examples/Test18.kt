package io.kotest.examples

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Test18 : FreeSpec({
    "context 1" - {
        "test 1" { 1 + 1 shouldBe 2 }
        "test 2" { 1 + 1 shouldBe 2 }
        "test 3" { 1 + 1 shouldBe 2 }
        "test 4" { 1 + 1 shouldBe 2 }
        "test 5" { 1 + 1 shouldBe 2 }
    }
    "context 2" - {
        "test 6" { 1 + 1 shouldBe 2 }
        "test 7" { 1 + 1 shouldBe 2 }
        "test 8" { 1 + 1 shouldBe 2 }
        "test 9" { 1 + 1 shouldBe 2 }
        "test 10" { 1 + 1 shouldBe 2 }
        "inner context 2" - {
            "test 11" { 1 + 1 shouldBe 2 }
            "test 12" { 1 + 1 shouldBe 2 }
            "test 13" { 1 + 1 shouldBe 2 }
        }
    }
    "context 3" - {
        "test 14" { 1 + 1 shouldBe 2 }
        "test 15" { 1 + 1 shouldBe 2 }
    }
})
