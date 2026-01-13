package io.kotest.examples.multiplatform

import kotlin.random.Random

actual fun generateUniqueId(): UniqueId {
   // this is not meant to be useful, just showing the principal of each platform having its own implementation and test
   return UniqueId(Random.nextInt(10000000, 99999999).toString() + "-" + Random.nextInt(10000000, 99999999))
}
