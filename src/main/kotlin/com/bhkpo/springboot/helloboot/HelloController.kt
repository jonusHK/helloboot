package com.bhkpo.springboot.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException


@RestController
class HelloController(val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        if (name.isNullOrBlank()) throw IllegalArgumentException()
        return helloService.sayHello(name)
    }
}