package com.bhkpo.springboot.config.autoconfig

import com.bhkpo.springboot.config.ConditionalMyOnClass
import com.bhkpo.springboot.config.EnableMyConfigurationProperties
import com.bhkpo.springboot.config.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import java.sql.Driver
import javax.sql.DataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.SimpleDriverDataSource

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
class DataSourceConfig {

    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    fun hikariDataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = HikariDataSource()
        dataSource.driverClassName = properties.driverClassName
        dataSource.jdbcUrl = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password
        return dataSource
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()
        dataSource.setDriverClass(Class.forName(properties.driverClassName) as Class<out Driver>)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password
        return dataSource
    }
}