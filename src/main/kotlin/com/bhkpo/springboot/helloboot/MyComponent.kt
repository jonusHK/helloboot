package com.bhkpo.springboot.helloboot

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS) // class, interface 같은 type 에 붙여질 것
@Component
annotation class MyComponent()
