package io.kotest.examples.native

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class KotlinTest {
   @Test
   fun myTest() {
      println("kotlin.test test case")
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
