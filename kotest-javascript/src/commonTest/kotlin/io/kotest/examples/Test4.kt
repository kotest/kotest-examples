package io.kotest.examples

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class Test4 : FunSpec({
    context("outer 1") {
        context("inner 1a") {
            test("test 1") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
            test("test 2") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
        }
        context("inner 1b") {
            test("test 3") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
            context("deep 1b-i") {
                test("test 4") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
                test("test 5") { delay(1.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 6") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
        }
    }
    context("outer 2") {
        context("inner 2a") {
            context("deep 2a-i") {
                test("test 7") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
                test("test 8") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 9") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 10") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
        }
        context("inner 2b") {
            test("test 11") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            test("test 12") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
            context("deep 2b-i") {
                test("test 13") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 14") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
        test("test 15") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
    }
    context("outer 3") {
        test("test 16") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
        test("test 17") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
        test("test 18") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
        test("test 19") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
    }
})
