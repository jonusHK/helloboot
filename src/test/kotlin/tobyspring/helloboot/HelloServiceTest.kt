package tobyspring.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class HelloServiceTest: AnnotationSpec() {

    @Test
    fun simpleHelloService() {
        val helloService = SimpleHelloService()

        val ret: String = helloService.sayHello("Test")

        ret shouldBe "Hello Test"
    }
}