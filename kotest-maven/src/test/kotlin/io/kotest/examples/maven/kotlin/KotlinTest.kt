package io.kotest.examples.maven.kotlin

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class KotlinTest  : FunSpec({

    test("kotlin test") {
        1 shouldBe 1
    }

})