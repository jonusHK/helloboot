package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
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