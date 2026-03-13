package io.kotest.examples

fun bitstring(bits: List<Boolean>): String {
   require(bits.isNotEmpty())
   return buildString {
      repeat(bits.size) {
         if (bits[it]) append("1") else append("0")
      }
   }
}
