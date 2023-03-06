package com.bhkpo.springboot.study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest: AnnotationSpec() {
    @Test
    fun configuration() {
        val ac = AnnotationConfigApplicationContext()
        ac.register(MyConfig::class.java)
        ac.refresh()

        val bean1: Bean1 = ac.getBean(Bean1::class.java)
        val bean2: Bean2 = ac.getBean(Bean2::class.java)

        bean1.common shouldBeSameInstanceAs bean2.common
    }

    @Test
    fun proxyCommonMethod() {
        val myConfigProxy: MyConfigProxy = MyConfigProxy()

        val bean1: Bean1 = myConfigProxy.bean1()
        val bean2: Bean2 = myConfigProxy.bean2()

        bean1.common shouldBeSameInstanceAs bean2.common
    }


    companion object {

        class MyConfigProxy: MyConfig() {
            private var common: Common? = null

            override fun common(): Common {
                if (this.common == null) {
                    this.common = super.common()
                }
                return this.common!!
            }
        }

        @Configuration
        class MyConfig {
            @Bean
            fun common(): Common {
                return Common()
            }

            @Bean
            fun bean1(): Bean1 {
                return Bean1(common())
            }

            @Bean
            fun bean2(): Bean2 {
                return Bean2(common())
            }
        }

        class Bean1(val common: Common) {}

        class Bean2(val common: Common) {}

        class Common {}
    }
}