package io.kotest.examples.wasm

import kotlin.math.roundToInt

fun celsiusToFahrenheit(c: Int): Int {
   return ((c * 1.8) + 32).roundToInt()
}
