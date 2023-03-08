package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "server")
class ServerProperties {
    lateinit var contextPath: String
    var port: Int? = null
}