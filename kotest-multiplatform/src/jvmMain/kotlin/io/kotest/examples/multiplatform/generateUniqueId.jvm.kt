package io.kotest.examples.multiplatform

actual fun generateUniqueId(): UniqueId {
   return UniqueId(java.util.UUID.randomUUID().toString())
}
