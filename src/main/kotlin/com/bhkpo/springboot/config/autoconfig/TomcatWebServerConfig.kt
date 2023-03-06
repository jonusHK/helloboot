package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils

@MyAutoConfiguration
@Conditional(TomcatWebServerConfig.Companion.TomcatCondition::class)
class TomcatWebServerConfig {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }

    companion object {
        class TomcatCondition: Condition {
            override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
                return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.classLoader)
            }
        }
    }
}