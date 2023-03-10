package com.bhkpo.springboot.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
annotation class MySpringBootApplication
