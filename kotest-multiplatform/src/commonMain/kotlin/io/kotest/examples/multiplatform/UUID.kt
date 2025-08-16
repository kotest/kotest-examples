package io.kotest.examples.multiplatform

/**
 * This is a UUID struct, but the implementations that generate the uuids are located
 * in the target-specific source sets.
 */
data class UUID(val value: String)

/**
 * This function will generate a UUID on each platform.
 *
 * This is a toy example of a multiplatform library and not intended to be accurate in
 * terms of uuid format! It exists to show how each platform can supply their own implementation
 * and Kotest can test them all!
 */
expect fun generateUUID(): UUID
