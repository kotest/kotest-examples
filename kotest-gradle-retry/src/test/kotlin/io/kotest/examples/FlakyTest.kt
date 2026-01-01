package io.kotest.examples

import io.kotest.core.spec.style.FunSpec
import kotlin.random.Random

/**
 * This test will fail randomly and is used to demonstrate the Gradle test-retry-plugin.
 */
class FlakyTest : FunSpec({
   test("will fail randomly") {
      if (Random.nextInt(0, 10) < 9)
         error("boom")
   }
})
