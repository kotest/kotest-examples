//package io.kotest.examples.wasm
//
//import io.kotest.core.spec.style.FreeSpec
//import io.kotest.matchers.comparables.shouldBeGreaterThan
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//class CoroutineTest : FreeSpec() {
//   init {
//      "I can use suspendable functions in a test" {
//         delay(10)
//         2 shouldBeGreaterThan 1
//      }
//      "I can launch coroutines from my test and the test will wait for completion" {
//         launch {
//            delay(10)
//         }
//         3 shouldBeGreaterThan 2
//      }
//   }
//}
