package io.kotest.examples.multiplatform

/**
 * This is the UniqueId struct, but the implementations that generate the ids are located
 * in the target-specific source sets.
 */
data class UniqueId(val value: String)

/**
 * This function will generate a [UniqueId] on each platform.
 *
 * This is a toy example of a multiplatform library and not intended to be useful in terms of id format.
 * It exists to show how each platform can supply their own implementation, and Kotest can test them all!
 */
expect fun generateUniqueId(): UniqueId
