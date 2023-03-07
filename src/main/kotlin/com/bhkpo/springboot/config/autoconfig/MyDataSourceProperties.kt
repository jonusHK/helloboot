package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "data")
class MyDataSourceProperties {
    lateinit var driverClassName: String
    lateinit var url: String
    lateinit var username: String
    lateinit var password: String
}
