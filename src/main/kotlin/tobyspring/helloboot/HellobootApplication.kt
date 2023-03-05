package tobyspring.helloboot

import org.springframework.boot.runApplication

@MySpringBootAnnotation
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
