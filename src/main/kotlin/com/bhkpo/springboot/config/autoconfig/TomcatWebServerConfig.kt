package com.bhkpo.springboot.config.autoconfig

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import com.bhkpo.springboot.config.MyAutoConfiguration

@MyAutoConfiguration
class TomcatWebServerConfig {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }
}