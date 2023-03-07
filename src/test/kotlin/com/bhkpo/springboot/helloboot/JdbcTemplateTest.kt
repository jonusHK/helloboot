package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional

@JdbcTest
@Transactional
class JdbcTemplateTest(
    @Autowired private val jdbcTemplate: JdbcTemplate
): AnnotationSpec() {

    override fun extensions() = listOf(SpringExtension)

    @Test
    fun insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Jonus", 3)
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1)

        val count: Long? = jdbcTemplate.queryForObject("select count(*) from hello", Long::class.java)
        count shouldBe 2
    }
}