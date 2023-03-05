package tobyspring.helloboot

import org.springframework.stereotype.Component

@Component
interface HelloService {
    fun sayHello(name: String): String
}