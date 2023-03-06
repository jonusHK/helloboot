package com.bhkpo.springboot.helloboot

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class HelloControllerTest: AnnotationSpec() {

    @Test
    fun helloController() {
        val helloController = HelloController(object: HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        val ret: String = helloController.hello("Test")

        ret shouldBe "Test"
    }

    @Test
    fun failsHelloController() {
        val helloController = HelloController(object: HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        shouldThrow<IllegalArgumentException> {
            helloController.hello(null)
        }
        shouldThrow<IllegalArgumentException> {
            helloController.hello("")
        }
        shouldThrow<IllegalArgumentException> {
            helloController.hello("     ")
        }
    }
}