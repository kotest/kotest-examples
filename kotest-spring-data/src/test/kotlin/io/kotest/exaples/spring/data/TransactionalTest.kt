package io.kotest.exaples.spring.data

import io.kotest.core.spec.style.FreeSpec
import io.kotest.exaples.spring.data.config.PostgresTCConfig
import io.kotest.matchers.shouldBe
import jakarta.transaction.Transactional
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.jdbc.core.JdbcTemplate


@SpringBootTest
@Transactional
@Import(PostgresTCConfig::class)
class TransactionalTest(
    private val kotestUserRepository: KotestUserRepository,
    private val jdbcTemplate: JdbcTemplate,
) : FreeSpec({

    beforeEach {
        kotestUserRepository.saveAll(
            listOf(
                KotestUserEntity(username = "user1"),
                KotestUserEntity(username = "user2"),
                KotestUserEntity(username = "user3"),
            )
        )
    }
    afterEach {
        jdbcTemplate.execute("ALTER SEQUENCE kotest_user_pk_sequence RESTART WITH 1")
    }

    "on the first test, should have 3 users with correct PK IDs" {
        with(kotestUserRepository.findAll()) {
            size shouldBe 3
            // IDS: 1,2,3
            forEachIndexed { index, kotestUserEntity ->
                kotestUserEntity.pkId shouldBe index + 1L
            }
        }
    }

    // the afterEach should have reset the sequence, and given us back IDs 1,2,3
    // but because we use transactional it seems the afterEach is called after the transaction is closed
    // this works with kotest 6.0.7 - making this test pass with IDs 4,5,6 for the CI to not fail
    "on the second test, should still have 3 users with the same PK IDs" {
        with(kotestUserRepository.findAll()) {
            size shouldBe 3
            // IDS: 4,5,6 (should have been 1,2,3 if the sequence was reset correctly)
            forEachIndexed { index, kotestUserEntity ->
                kotestUserEntity.pkId shouldBe index + 4L
            }
        }
    }
})