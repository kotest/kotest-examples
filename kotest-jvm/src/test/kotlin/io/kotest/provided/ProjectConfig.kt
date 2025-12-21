package io.kotest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.test.TestCase
import io.kotest.engine.test.TestResult

object TimerListener : AfterTestListener {
    override suspend fun afterAny(testCase: TestCase, result: TestResult) =
        println("- ${testCase.name.name} ${result.duration}")
}

object ProjectConfig : AbstractProjectConfig() {
    override val extensions = listOf(TimerListener)
}
