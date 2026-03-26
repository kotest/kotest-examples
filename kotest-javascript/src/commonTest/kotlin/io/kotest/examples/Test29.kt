package io.kotest.examples

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Test29 : ShouldSpec({
    should("test 1") { 1 + 1 shouldBe 2 }
    should("test 2") { 1 + 1 shouldBe 2 }
    should("test 3") { 1 + 1 shouldBe 2 }
    should("test 4") { 1 + 1 shouldBe 2 }
    should("test 5") { 1 + 1 shouldBe 2 }
    context("context 1") {
        should("test 6") { 1 + 1 shouldBe 2 }
        should("test 7") { 1 + 1 shouldBe 2 }
        should("test 8") { 1 + 1 shouldBe 2 }
        should("test 9") { 1 + 1 shouldBe 2 }
    }
    context("context 2") {
        should("test 10") { 1 + 1 shouldBe 2 }
        should("test 11") { 1 + 1 shouldBe 2 }
        should("test 12") { 1 + 1 shouldBe 2 }
        should("test 13") { 1 + 1 shouldBe 2 }
    }
    context("context 3") {
        should("test 14") { 1 + 1 shouldBe 2 }
        should("test 15") { 1 + 1 shouldBe 2 }
        should("test 16") { 1 + 1 shouldBe 2 }
        should("test 17") { 1 + 1 shouldBe 2 }
    }
    context("context 4") {
        should("test 18") { 1 + 1 shouldBe 2 }
        should("test 19") { 1 + 1 shouldBe 2 }
        should("test 20") { 1 + 1 shouldBe 2 }
    }
})
