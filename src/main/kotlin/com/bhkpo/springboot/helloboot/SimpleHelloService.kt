package com.bhkpo.springboot.helloboot

import org.springframework.stereotype.Component

@Component
class SimpleHelloService : HelloService {
    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}