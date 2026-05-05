package io.kotest.examples.jvm

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.opentest4j.TestAbortedException

class JUnitTest {

   @Test
   fun junitTest1() {
      Thread.sleep(2000)
      1 shouldBe 1
   }

   @Test
   fun junitTest2() {
      throw TestAbortedException()
   }
}
