package com.bhkpo.springboot.config

import org.springframework.context.annotation.Import
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Import(MyConfigurationPropertiesImportSelect::class)
annotation class EnableMyConfigurationProperties(val value: KClass<*>)

