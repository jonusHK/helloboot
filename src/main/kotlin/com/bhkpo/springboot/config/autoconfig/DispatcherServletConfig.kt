package com.bhkpo.springboot.config.autoconfig

import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet
import com.bhkpo.springboot.config.MyAutoConfiguration

@MyAutoConfiguration
class DispatcherServletConfig {

    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}