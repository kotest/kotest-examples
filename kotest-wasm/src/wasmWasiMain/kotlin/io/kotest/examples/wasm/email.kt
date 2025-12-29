package io.kotest.examples.wasm

/**
 * Extremely basic email validator, not intended to do anything complicated, is just for demo purposes.
 */
fun validateEmail(email: String): Boolean {
   return email.matches(".+@.+\\..+".toRegex())
}
