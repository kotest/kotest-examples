package io.kotest.examples

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class Test2 : FunSpec({
    context("level 1a") {
        context("level 2a") {
            test("test 1") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            test("test 2") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
            test("test 3") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
        }
        context("level 2b") {
            test("test 4") { delay(1.milliseconds); 1 + 1 shouldBe 2 }
            test("test 5") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
            context("level 3a") {
                test("test 6") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
                test("test 7") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
    }
    context("level 1b") {
        context("level 2c") {
            context("level 3b") {
                test("test 8") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
                test("test 9") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
                test("test 10") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 11") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
            test("test 12") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
        }
        context("level 2d") {
            test("test 13") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
            test("test 14") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            context("level 3c") {
                test("test 15") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
                test("test 16") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
                test("test 17") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 18") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
            test("test 19") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
        }
    }
})
