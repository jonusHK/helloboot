package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest(
    @Autowired private val helloRepository: HelloRepository
): AnnotationSpec() {

    override fun extensions() = listOf(SpringExtension)

    @Test
    fun findHelloFailed() {
        helloRepository.findHello("Jonus") shouldBe null
    }

    @Test
    fun increaseCount() {
        helloRepository.countOf("Jonus") shouldBe 0

        helloRepository.increaseCount("Jonus")
        helloRepository.countOf("Jonus") shouldBe 1

        helloRepository.increaseCount("Jonus")
        helloRepository.countOf("Jonus") shouldBe 2
    }
}