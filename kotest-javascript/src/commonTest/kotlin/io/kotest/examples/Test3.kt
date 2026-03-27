package io.kotest.examples

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class Test3 : FunSpec({
    test("test 1") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
    context("group a") {
        test("test 2") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
        test("test 3") { delay(1.milliseconds); 1 + 1 shouldBe 2 }
        context("group a-i") {
            test("test 4") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
            test("test 5") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
            context("group a-i-alpha") {
                test("test 6") { delay(4.milliseconds); 1 + 1 shouldBe 2 }
                test("test 7") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
        test("test 8") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
    }
    context("group b") {
        context("group b-i") {
            test("test 9") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
            test("test 10") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
        }
        context("group b-ii") {
            test("test 11") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            context("group b-ii-alpha") {
                test("test 12") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
                test("test 13") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 14") { delay(6.milliseconds); 1 + 1 shouldBe 2 }
        }
    }
    test("test 15") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
    context("group c") {
        test("test 16") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
        test("test 17") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
        test("test 18") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
    }
})
