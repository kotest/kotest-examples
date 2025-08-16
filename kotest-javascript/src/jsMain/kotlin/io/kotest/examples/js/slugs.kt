package io.kotest.examples.js

@JsModule("slugify")
@JsNonModule
external fun slugify(s: String): String

fun slugme(string: String): String {
   return slugify(string)
}
