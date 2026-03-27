package io.kotest.examples

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class Test5 : FunSpec({
    context("section 1") {
        context("section 1.1") {
            test("test 1") { delay(5.milliseconds); 1 + 1 shouldBe 2 }
            test("test 2") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            context("section 1.1.1") {
                test("test 3") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 4") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
        context("section 1.2") {
            context("section 1.2.1") {
                test("test 5") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
                test("test 6") { delay(1.milliseconds); 1 + 1 shouldBe 2 }
            }
            context("section 1.2.2") {
                test("test 7") { delay(4.milliseconds); 1 + 1 shouldBe 2 }
                test("test 8") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
    }
    context("section 2") {
        test("test 9") { delay(1.milliseconds); 1 + 1 shouldBe 2 }
        context("section 2.1") {
            context("section 2.1.1") {
                test("test 10") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
                test("test 11") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
            }
            test("test 12") { delay(7.milliseconds); 1 + 1 shouldBe 2 }
            context("section 2.1.2") {
                test("test 13") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 14") { delay(3.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
        context("section 2.2") {
            test("test 15") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
            test("test 16") { delay(4.milliseconds); 1 + 1 shouldBe 2 }
            context("section 2.2.1") {
                test("test 17") { delay(2.milliseconds); 1 + 1 shouldBe 2 }
                test("test 18") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 19") { delay(8.milliseconds); 1 + 1 shouldBe 2 }
                test("test 20") { delay(9.milliseconds); 1 + 1 shouldBe 2 }
            }
        }
    }
})
