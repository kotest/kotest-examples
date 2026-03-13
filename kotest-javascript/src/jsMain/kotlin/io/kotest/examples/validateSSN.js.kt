package io.kotest.examples

private val socialRegex = "^\\d{3}-\\d{2}-\\d{4}$".toRegex()

actual fun validateSocial(ssn: String): Boolean {
   return socialRegex.matches(ssn) && !ssn.contains("0") && !ssn.startsWith("666")

}
