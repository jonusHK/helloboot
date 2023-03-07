package com.bhkpo.springboot.helloboot

import com.bhkpo.springboot.config.EnableMyConfigurationProperties
import org.springframework.boot.runApplication
import com.bhkpo.springboot.config.MySpringBootApplication
import com.bhkpo.springboot.config.autoconfig.MyDataSourceProperties
import javax.annotation.PostConstruct
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate

@MySpringBootApplication
class HellobootApplication(val jdbcTemplate: JdbcTemplate) {

    @PostConstruct
    fun init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)")
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
