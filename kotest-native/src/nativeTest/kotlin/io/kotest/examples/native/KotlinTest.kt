package io.kotest.examples.native

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertSame

class KotlinTest {
   @Test
   fun myTest() {
      println("kotlin.test test case")
      assertSame(1, 2)
   }

   @BeforeTest
   fun beforeTest() {
      println("kotlin.test beforeTest")
   }

   @AfterTest
   fun afterTest() {
      println("kotlin.test afterTest")
   }
}
