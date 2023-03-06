package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@MyAutoConfiguration
class PropertyPlaceholderConfig {

    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }
}