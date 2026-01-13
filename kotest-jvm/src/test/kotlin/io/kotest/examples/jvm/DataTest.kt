package io.kotest.examples.jvm

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withContexts
import io.kotest.datatest.withTests
import io.kotest.matchers.string.shouldNotInclude

class DataTest : FunSpec() {
   init {
      withContexts("foo", "bar", "baz") { a ->
         withTests("tinker", "tailor", "toaster") { t ->
            a shouldNotInclude t
         }
      }
   }
}
