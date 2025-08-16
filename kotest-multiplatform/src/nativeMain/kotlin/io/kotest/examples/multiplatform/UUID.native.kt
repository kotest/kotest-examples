package io.kotest.examples.multiplatform

import kotlin.random.Random
import kotlin.time.TimeSource

private val mark = TimeSource.Monotonic.markNow()

actual fun generateUUID(): UUID {
   // this is not meant to be a real uuid, just showing the principal of each platform having its own implementation
   return UUID(mark.elapsedNow().inWholeMilliseconds.toString() + "-" + Random.nextInt(10000000, 99999999).toString())
}
