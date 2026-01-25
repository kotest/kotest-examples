package io.kotest.exaples.spring.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KotestUserRepository : JpaRepository<KotestUserEntity, Long>
