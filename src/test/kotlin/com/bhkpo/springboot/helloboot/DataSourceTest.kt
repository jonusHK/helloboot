package com.bhkpo.springboot.helloboot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.extensions.spring.SpringExtension
import java.sql.Connection
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.transaction.annotation.Transactional

@JdbcTest
@Transactional
class DataSourceTest(
    @Autowired private val dataSource: DataSource
): AnnotationSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Test
    fun connect() {
        val connection: Connection = dataSource.connection
        connection.close()
    }
}