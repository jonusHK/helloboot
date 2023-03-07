package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class HelloServiceTest: AnnotationSpec() {
    companion object {
        @JvmStatic private val helloRepositoryStub = object: HelloRepository {
            override fun findHello(name: String): Hello? {
                return null
            }

            override fun increaseCount(name: String) {}
        }
    }

    @Test
    fun simpleHelloService() {
        val helloService = SimpleHelloService(helloRepositoryStub)

        val ret: String = helloService.sayHello("Test")

        ret shouldBe "Hello Test"
    }

    @Test
    fun helloDecorator() {
        val decorator: HelloDecorator = HelloDecorator(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        val ret: String = decorator.sayHello("Test")

        ret shouldBe "*Test*"

    }
}