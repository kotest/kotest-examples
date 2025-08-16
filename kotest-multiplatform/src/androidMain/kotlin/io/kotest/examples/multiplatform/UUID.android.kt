package io.kotest.examples.multiplatform

import kotlin.random.Random

actual fun generateUUID(): UUID {
   // this is not meant to be a real uuid, just showing the principal of each platform having its own implementation
   return UUID("android-" + Random.nextInt(10000000, 99999999).toString())
}
