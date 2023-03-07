package com.bhkpo.springboot.helloboot

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class HelloDecorator(val helloService: HelloService): HelloService {
    override fun sayHello(name: String): String {
        return "*${helloService.sayHello(name)}*"
    }

    override fun countOf(name: String): Int {
        return helloService.countOf(name)
    }
}