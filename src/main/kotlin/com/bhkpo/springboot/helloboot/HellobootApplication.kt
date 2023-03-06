package com.bhkpo.springboot.helloboot

import org.springframework.boot.runApplication
import com.bhkpo.springboot.config.MySpringBootApplication
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MySpringBootApplication
class HellobootApplication {

    @Bean
    fun applicationRunner(env: Environment): ApplicationRunner {
        return ApplicationRunner {
            val name: String? = env.getProperty("my.name")
            println("my.name $name")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
