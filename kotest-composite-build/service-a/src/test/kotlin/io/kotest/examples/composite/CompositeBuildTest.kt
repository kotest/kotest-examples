package io.kotest.examples.composite

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.File

class CompositeBuildTest : FunSpec({

   test("runs as part of the composite build") {
      System.getProperty("composite") shouldBe "true"
   }

   test("env var configured on the Test task is visible") {
      System.getenv("SERVICE_A_ENV") shouldBe "from-test-task"
   }

   test("working dir is the composite root") {
      File("settings.gradle.kts").readText().contains("includeBuild") shouldBe true
   }
})
