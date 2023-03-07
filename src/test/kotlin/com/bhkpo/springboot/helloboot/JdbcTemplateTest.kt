package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HellobootTest
class JdbcTemplateTest(
    @Autowired private val jdbcTemplate: JdbcTemplate
): AnnotationSpec() {

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Jonus", 3)
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1)

        val count: Long? = jdbcTemplate.queryForObject("select count(*) from hello", Long::class.java)
        count shouldBe 2
    }
}