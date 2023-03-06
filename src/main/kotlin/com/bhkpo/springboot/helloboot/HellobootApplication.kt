package com.bhkpo.springboot.helloboot

import org.springframework.boot.runApplication
import com.bhkpo.springboot.config.MySpringBootApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
