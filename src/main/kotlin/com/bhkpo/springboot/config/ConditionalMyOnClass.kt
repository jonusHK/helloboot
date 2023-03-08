package com.bhkpo.springboot.config

import org.springframework.context.annotation.Conditional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(MyOnClassCondition::class)
annotation class ConditionalMyOnClass(val value: String)
