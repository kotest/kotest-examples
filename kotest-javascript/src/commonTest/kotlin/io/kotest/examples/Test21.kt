package io.kotest.examples

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Test21 : DescribeSpec({
    describe("group 1") {
        it("test 1") { 1 + 1 shouldBe 2 }
        it("test 2") { 1 + 1 shouldBe 2 }
        it("test 3") { 1 + 1 shouldBe 2 }
        it("test 4") { 1 + 1 shouldBe 2 }
        context("subgroup 1") {
            it("test 5") { 1 + 1 shouldBe 2 }
            it("test 6") { 1 + 1 shouldBe 2 }
            it("test 7") { 1 + 1 shouldBe 2 }
        }
    }
    describe("group 2") {
        it("test 8") { 1 + 1 shouldBe 2 }
        it("test 9") { 1 + 1 shouldBe 2 }
        it("test 10") { 1 + 1 shouldBe 2 }
        it("test 11") { 1 + 1 shouldBe 2 }
        context("subgroup 2") {
            it("test 12") { 1 + 1 shouldBe 2 }
            it("test 13") { 1 + 1 shouldBe 2 }
            it("test 14") { 1 + 1 shouldBe 2 }
        }
    }
    describe("group 3") {
        it("test 15") { 1 + 1 shouldBe 2 }
        it("test 16") { 1 + 1 shouldBe 2 }
        it("test 17") { 1 + 1 shouldBe 2 }
        it("test 18") { 1 + 1 shouldBe 2 }
    }
})
