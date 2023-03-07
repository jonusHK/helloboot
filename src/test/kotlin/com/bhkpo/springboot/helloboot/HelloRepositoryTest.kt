package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HellobootTest
class HelloRepositoryTest(
    @Autowired private val helloRepository: HelloRepository,
    @Autowired private val jdbcTemplate: JdbcTemplate
): AnnotationSpec() {

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun findHelloFailed() {
        helloRepository.findHello("Jonus") shouldBe null
    }

    @Test
    fun increaseCount() {
        helloRepository.countOf("Jonus") shouldBe 0

        helloRepository.increaseCount("Jonus")
        helloRepository.countOf("Jonus") shouldBe 1

        helloRepository.increaseCount("Jonus")
        helloRepository.countOf("Jonus") shouldBe 2
    }
}