package io.kotest.examples.jvm

private val socialRegex = "^\\d{3}-\\d{2}-\\d{4}$".toRegex()

fun validateSocial(ssn: String): Boolean {
   return socialRegex.matches(ssn) && !ssn.contains("0") && !ssn.startsWith("666")
}
