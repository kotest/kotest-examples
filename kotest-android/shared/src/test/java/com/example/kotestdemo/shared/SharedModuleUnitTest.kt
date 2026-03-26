package com.example.kotestdemo.shared

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * Local tests execute on your development machine or a server, so they're also called host-side tests.
 * They're usually small and fast, isolating the subject under test from the rest of the app.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SharedModuleUnitTest : BehaviorSpec({

   Given("This is a test") {
      When("test is called") {
         Then("Pass the test") {
            2 +2 shouldBe 4
         }
      }
   }

   Given("This is another test") {
      When("test is called") {
         Then("Pass the test") {
            2 +2 shouldBe 4
         }
      }
   }
})
