package io.kotest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.test.TestCase
import io.kotest.engine.test.TestResult

/**
 * An example Kotest extension that prints the duration of each test.
 */
object TimerListener : AfterTestListener {
   override suspend fun afterAny(testCase: TestCase, result: TestResult) =
      println("- ${testCase.name.name} ${result.duration}")
}

/**
 * Example of product config, registering a Kotest extension.
 */
object ProjectConfig : AbstractProjectConfig() {
   override val extensions = listOf(TimerListener)
}
