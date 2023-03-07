package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyAutoConfiguration
import com.bhkpo.springboot.config.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils.findAnnotation
import org.springframework.core.env.Environment

@MyAutoConfiguration
class PropertyPostProcessorConfig {

    @Bean
    fun propertyPostProcessor(env: Environment): BeanPostProcessor {
        return object : BeanPostProcessor {
            override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
                val annotation: MyConfigurationProperties? = findAnnotation(bean.javaClass, MyConfigurationProperties::class.java)
                return annotation?.let {
                    Binder.get(env).bindOrCreate("", bean.javaClass)
                } ?: bean
            }

        }
    }
}