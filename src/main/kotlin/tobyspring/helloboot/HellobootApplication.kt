package tobyspring.helloboot

import org.springframework.boot.runApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
