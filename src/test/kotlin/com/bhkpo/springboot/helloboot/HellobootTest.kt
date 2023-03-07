package com.bhkpo.springboot.helloboot

import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ContextConfiguration(classes = [HellobootApplication::class])
@TestPropertySource("classpath:/application.properties")
@Transactional
annotation class HellobootTest
