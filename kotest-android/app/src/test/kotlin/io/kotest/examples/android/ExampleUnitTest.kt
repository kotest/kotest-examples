package io.kotest.examples.android

import io.kotest.core.spec.style.BehaviorSpec
import org.junit.Assert

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * Local tests execute on your development machine or a server, so they're also called host-side tests.
 * They're usually small and fast, isolating the subject under test from the rest of the app.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : BehaviorSpec({

   Given("This is a test") {
      When("test is called") {
         Then("Pass the test") {
             Assert.assertEquals(4, 2 + 2)
         }
      }
   }

   Given("This is another test") {
      When("test is called") {
         Then("Pass the test") {
             Assert.assertEquals(4, 2 + 2)
         }
      }
   }
})
