package io.kotest.examples.multimodule.importer

import io.kotest.examples.multimodule.imported.bitstring

fun bitstringWithPrefix(prefix: String, bits: List<Boolean>): String {
    return "$prefix${bitstring(bits)}"
}