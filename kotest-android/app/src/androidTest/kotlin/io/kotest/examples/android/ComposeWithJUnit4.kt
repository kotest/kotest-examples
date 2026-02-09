package io.kotest.examples.android

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test using JUnit4, which will execute on an Android device.
 *
 * Instrumented tests run on an Android device, either physical or emulated.
 * The app is built and installed alongside a test app that injects commands and reads the state.
 * Instrumented tests are usually UI tests, launching an app and then interacting with it.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ComposeWithJUnit4 {

   @get:Rule
   val composeTestRule = createComposeRule()

   @Test
   fun initial() {
      composeTestRule.setContent {
         TestComposable()
      }

      composeTestRule.onNodeWithText("0").assertExists()
      composeTestRule.onNodeWithText("Click me!").assertExists()
   }

   @Test
   fun increment() {
      composeTestRule.setContent {
         TestComposable()
      }

      composeTestRule.onNodeWithText("Click me!").performClick()
      composeTestRule.onNodeWithText("1").assertExists()
   }
}

/**
 * Simple composable which has a counter and a button that will increase the counter
 * each time it is clicked.
 */
@Composable
private fun TestComposable() {
   var counter by remember { mutableStateOf(0) }
   Button(onClick = { counter++ }) { Text("Click me!") }
   Text(counter.toString())
}
