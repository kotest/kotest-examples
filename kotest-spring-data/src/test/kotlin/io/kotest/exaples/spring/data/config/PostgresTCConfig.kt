package io.kotest.exaples.spring.data.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class PostgresTCConfig {
    @Bean
    @ServiceConnection
    fun postgresContainer() = PostgreSQLContainer<Nothing>("postgres:16.8").apply { start() }
}
