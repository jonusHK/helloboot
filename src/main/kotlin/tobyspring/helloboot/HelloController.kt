package tobyspring.helloboot

import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController(
    val helloService: HelloService,
    val applicationContext: ApplicationContext
) {

    init {
        println("init")
        println("applicationContext - ${this.applicationContext}")
    }

    @GetMapping("/hello")
    fun hello(name: String): String {
        return helloService.sayHello(requireNotNull(name))
    }
}