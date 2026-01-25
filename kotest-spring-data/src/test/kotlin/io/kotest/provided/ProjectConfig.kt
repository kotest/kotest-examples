package io.kotest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension

object ProjectConfig : AbstractProjectConfig() {
    override val extensions = listOf(SpringExtension())
}
