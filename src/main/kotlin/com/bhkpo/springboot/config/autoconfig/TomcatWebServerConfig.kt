package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.ConditionalMyOnClass
import com.bhkpo.springboot.config.MyAutoConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@Import(ServerProperties::class)
class TomcatWebServerConfig {

    @Value("\${server.contextPath}")
    lateinit var contextPath: String

    @Value("\${server.port}")
    var port: Int? = null

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(properties: ServerProperties): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.contextPath = properties.contextPath
        factory.port = properties.port!!
        return factory
    }
}