package com.bhkpo.springboot

import com.bhkpo.springboot.helloboot.HelloRepository
import com.bhkpo.springboot.helloboot.HelloService
import com.bhkpo.springboot.helloboot.HellobootTest
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired

@HellobootTest
class HelloServiceCountTest(
    @Autowired private val helloService: HelloService,
    @Autowired private val helloRepository: HelloRepository
): AnnotationSpec() {

    override fun extensions() = listOf(SpringExtension)

    @Test
    fun sayHelloIncreaseCount() {
        for (count in 1..10) {
            helloService.sayHello("Jonus")
            helloRepository.countOf("Jonus") shouldBe count
        }
    }

}