package com.bhkpo.springboot.helloboot

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


@Repository
class HelloRepositoryJdbc(val jdbcTemplate: JdbcTemplate): HelloRepository {
    override fun findHello(name: String): Hello? {
        return try {
            jdbcTemplate.queryForObject("select * from hello where name = '$name'") { rs, _ -> Hello(rs.getString("name"), rs.getInt("count"))
            }
        } catch(e: EmptyResultDataAccessException) {
            null
        }
    }

    override fun increaseCount(name: String) {
        val hello: Hello? = findHello(name)
        hello?.let {
            jdbcTemplate.update("update hello set count = ? where name = ?", hello.count + 1, name)
        } ?: jdbcTemplate.update("insert into hello values(?, ?)", name, 1)
    }
}