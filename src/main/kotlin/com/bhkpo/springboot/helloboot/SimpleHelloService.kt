package com.bhkpo.springboot.helloboot

import org.springframework.stereotype.Component

@Component
class SimpleHelloService(val helloRepository: HelloRepository): HelloService {
    override fun sayHello(name: String): String {
        helloRepository.increaseCount(name)
        return "Hello $name"
    }

    override fun countOf(name: String): Int {
        return helloRepository.countOf(name)
    }
}