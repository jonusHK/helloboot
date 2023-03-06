package com.bhkpo.springboot.helloboot

import org.springframework.stereotype.Component

@Component
interface HelloService {
    fun sayHello(name: String): String
}