package tobyspring.helloboot

import org.springframework.boot.runApplication
import tobyspring.config.MySpringBootApplication

@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
