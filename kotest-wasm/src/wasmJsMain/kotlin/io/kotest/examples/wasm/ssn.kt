package io.kotest.examples.wasm

/**
 * This function returns true if a social security number is in the form ddd-dd-dddd.
 *
 * An SSN must not allow a 0 in any position, and the first three digits should not be 666.
 */
fun validateSocial(ssn: String): Boolean {
   if (!ssn.matches("\\d{3}-\\d{2}-\\d{4}".toRegex())) return false
   if (ssn.any { it == '0' }) return false
   return ssn[0] != '6' && ssn[1] != '6' && ssn[2] != '6'
}
