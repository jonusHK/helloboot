package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyAutoConfiguration
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfiguration
class ServerPropertiesConfig {
    @Bean
    fun serverProperties(environment: Environment): ServerProperties {
//        val properties = ServerProperties()
//        properties.contextPath = environment.getProperty("contextPath").toString()
//        properties.port = environment.getProperty("port")?.toInt()
//        return properties
        return Binder.get(environment).bind("", ServerProperties::class.java).get()
    }
}