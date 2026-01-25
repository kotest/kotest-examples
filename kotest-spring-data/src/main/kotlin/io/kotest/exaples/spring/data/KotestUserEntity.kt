package io.kotest.exaples.spring.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator


@Entity(name = "kotest_user")
class KotestUserEntity(
    val username: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kotest_user_pk_sequence")
    @SequenceGenerator(name = "kotest_user_pk_sequence", allocationSize = 1)
    var pkId: Long? = null

}
