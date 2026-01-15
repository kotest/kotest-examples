package io.kotest.examples.wasm

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withShoulds
import io.kotest.matchers.string.shouldStartWith

class DataTests : ShouldSpec() {
   init {
      withShoulds("tinker", "tailer", "trader") { t ->
         t.shouldStartWith("t")
      }
   }
}
